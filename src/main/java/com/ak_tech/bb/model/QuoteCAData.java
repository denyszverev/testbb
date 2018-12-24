package com.ak_tech.bb.model;

import java.util.Objects;

public class QuoteCAData {
    private String Value;
    private Double ExchangeRate;
    private String ValueForCustoms;
    private String AES;
    private String RIV;
    private String AC;
    private String Form1;
    private String CustomsDuties;
    private String CustomsGST;
    private String CustomsPST;
    private String CustomsHST;
    private String CustomsQST;
    private String CustomsClearance;
    private String CustomsClearanceGST;
    private String CustomsClearancePST;
    private String CustomsClearanceHST;
    private String CustomsClearanceQST;
    private String GrandTotalFees;

    public String getValue() {
        return Value;
    }

    public Double getExchangeRate() {
        return ExchangeRate;
    }

    public String getValueForCustoms() {
        return ValueForCustoms;
    }

    public String getAES() {
        return AES;
    }

    public String getRIV() {
        return RIV;
    }

    public String getAC() {
        return AC;
    }

    public String getForm1() {
        return Form1;
    }

    public String getCustomsDuties() {
        return CustomsDuties;
    }

    public String getCustomsGST() {
        return CustomsGST;
    }

    public String getCustomsPST() {
        return CustomsPST;
    }

    public String getCustomsHST() {
        return CustomsHST;
    }

    public String getCustomsQST() {
        return CustomsQST;
    }

    public String getCustomsClearance() {
        return CustomsClearance;
    }

    public String getCustomsClearanceGST() {
        return CustomsClearanceGST;
    }

    public String getCustomsClearancePST() {
        return CustomsClearancePST;
    }

    public String getCustomsClearanceHST() {
        return CustomsClearanceHST;
    }

    public String getCustomsClearanceQST() {
        return CustomsClearanceQST;
    }

    public String getGrandTotalFees() {
        return GrandTotalFees;
    }

    public QuoteCAData withValue(String value) {
        this.Value = value;
        return this;
    }

    public QuoteCAData withExchangeRate(Double exchangeRate) {
        this.ExchangeRate = exchangeRate;
        return this;
    }

    public QuoteCAData withValueForCustoms(String valueForCustoms) {
        this.ValueForCustoms = valueForCustoms;
        return this;
    }

    public QuoteCAData withAES(String AES) {
        this.AES = AES;
        return this;
    }

    public QuoteCAData withRIV(String RIV) {
        this.RIV = RIV;
        return this;
    }

    public QuoteCAData withAC(String AC) {
        this.AC = AC;
        return this;
    }

    public QuoteCAData withForm1(String form1) {
        this.Form1 = form1;
        return this;
    }

    public QuoteCAData withCustomsDuties(String customsDuties) {
        this.CustomsDuties = customsDuties;
        return this;
    }

    public QuoteCAData withCustomsGST(String customsGST) {
        this.CustomsGST = customsGST;
        return this;
    }

    public QuoteCAData withCustomsPST(String customsPST) {
        this.CustomsPST = customsPST;
        return this;
    }

    public QuoteCAData withCustomsHST(String customsHST) {
        CustomsHST = customsHST;
        return this;
    }

    public QuoteCAData withCustomsQST(String customsQST) {
        this.CustomsQST = customsQST;
        return this;
    }

    public QuoteCAData withCustomsClearance(String customsClearance) {
        this.CustomsClearance = customsClearance;
        return this;
    }

    public QuoteCAData withCustomsClearanceGST(String customsClearanceGST) {
        this.CustomsClearanceGST = customsClearanceGST;
        return this;
    }

    public QuoteCAData withCustomsClearancePST(String customsClearancePST) {
        this.CustomsClearancePST = customsClearancePST;
        return this;
    }

    public QuoteCAData withCustomsClearanceHST(String customsClearanceHST) {
        this.CustomsClearanceHST = customsClearanceHST;
        return this;
    }

    public QuoteCAData withCustomsClearanceQST(String customsClearanceQST) {
        this.CustomsClearanceQST = customsClearanceQST;
        return this;
    }

    public QuoteCAData withGrandTotalFees(String grandTotalFees) {
        this.GrandTotalFees = grandTotalFees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteCAData quoteCAData = (QuoteCAData) o;
        return Objects.equals(Value, quoteCAData.Value) &&
                Objects.equals(ExchangeRate, quoteCAData.ExchangeRate) &&
                Objects.equals(ValueForCustoms, quoteCAData.ValueForCustoms) &&
                Objects.equals(AES, quoteCAData.AES) &&
                Objects.equals(RIV, quoteCAData.RIV) &&
                Objects.equals(AC, quoteCAData.AC) &&
                Objects.equals(Form1, quoteCAData.Form1) &&
                Objects.equals(CustomsDuties, quoteCAData.CustomsDuties) &&
                Objects.equals(CustomsGST, quoteCAData.CustomsGST) &&
                Objects.equals(CustomsPST, quoteCAData.CustomsPST) &&
                Objects.equals(CustomsHST, quoteCAData.CustomsHST) &&
                Objects.equals(CustomsQST, quoteCAData.CustomsQST) &&
                Objects.equals(CustomsClearance, quoteCAData.CustomsClearance) &&
                Objects.equals(CustomsClearanceGST, quoteCAData.CustomsClearanceGST) &&
                Objects.equals(CustomsClearancePST, quoteCAData.CustomsClearancePST) &&
                Objects.equals(CustomsClearanceHST, quoteCAData.CustomsClearanceHST) &&
                Objects.equals(CustomsClearanceQST, quoteCAData.CustomsClearanceQST) &&
                Objects.equals(GrandTotalFees, quoteCAData.GrandTotalFees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Value, ExchangeRate, ValueForCustoms, AES, RIV, AC, Form1, CustomsDuties, CustomsGST, CustomsPST, CustomsHST, CustomsQST, CustomsClearance, CustomsClearanceGST, CustomsClearancePST, CustomsClearanceHST, CustomsClearanceQST, GrandTotalFees);
    }

    @Override
    public String toString() {
        return "QuoteCAData{" +
                "Value='" + Value + '\'' +
                ", ExchangeRate=" + ExchangeRate +
                ", ValueForCustoms='" + ValueForCustoms + '\'' +
                ", AES='" + AES + '\'' +
                ", RIV='" + RIV + '\'' +
                ", AC='" + AC + '\'' +
                ", Form1='" + Form1 + '\'' +
                ", customsDuties='" + CustomsDuties + '\'' +
                ", CustomsGST='" + CustomsGST + '\'' +
                ", CustomsPST='" + CustomsPST + '\'' +
                ", CustomsHST='" + CustomsHST + '\'' +
                ", CustomsQST='" + CustomsQST + '\'' +
                ", CustomsClearance='" + CustomsClearance + '\'' +
                ", CustomsClearanceGST='" + CustomsClearanceGST + '\'' +
                ", CustomsClearancePST='" + CustomsClearancePST + '\'' +
                ", CustomsClearanceHST='" + CustomsClearanceHST + '\'' +
                ", CustomsClearanceQST='" + CustomsClearanceQST + '\'' +
                ", grandTotalFees='" + GrandTotalFees + '\'' +
                '}';
    }
}
