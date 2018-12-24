package com.ak_tech.bb.calculatorLogic;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class RateParser {
    private static Properties properties;
    //todo constructor


    public RateParser(Properties properties) {
        this.properties = properties;
    }

    public RateParser() {
    }
//    public static void main(String[] args) {
//        double dsa = readRate();
//        saveRate();
//    }

    public static void saveRate() {
        try {
            Double exchangeRate = getExchangeRate();
            File rateFile = new File(properties.getProperty("pathForRateFile"));
            FileWriter fw = new FileWriter(rateFile);
            try {
                fw.write(String.valueOf(exchangeRate));
            } catch (IOException iox) {

            } finally {
                fw.close();
            }

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }

    public static Double getExchangeRate() {
        String json = ClientBuilder.newClient()
                .target("https://www.bankofcanada.ca/valet/observations/group/FX_RATES_DAILY/json")
                .request().accept(MediaType.APPLICATION_JSON).get(String.class);

        JsonObject fullJobj = new Gson().fromJson(json, JsonObject.class);
        JsonArray resultObservations = fullJobj.get("observations").getAsJsonArray();
        int lastRate = resultObservations.size() - 1;
        Object object = resultObservations.get(lastRate);
        Object getObjFXUSDCAD = ((JsonElement) object).getAsJsonObject().get("FXUSDCAD");
        Object getValue = ((JsonElement) getObjFXUSDCAD).getAsJsonObject().get("v");
        return (double) ((JsonElement) getValue).getAsDouble();
    }

    public static Double readRate() {
        Date date = new Date();
        File file = new File(properties.getProperty("pathForRateFile"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH");
        String dateNow = sdf.format(date);
        String dateLastModifiedFile = sdf.format(new Date(file.lastModified()));
//        System.out.println("Date modified file: " + dateLastModifiedFile);
//        System.out.println("Date now: " + dateNow);
        if (!dateNow.equals(dateLastModifiedFile)) {
            saveRate();
        }

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextDouble()) {
                return scan.nextDouble();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            //todo exceptions logger to file
        }
        return null;
    }
}

