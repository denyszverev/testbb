package com.ak_tech.bb.model;

import java.util.Objects;

public class QuoteUSAData {
    private String value;
    private String valueForCustoms;
    private String CustomsDuties;
    private String CustomsMPF;
    private String CustomsHMF;
    private String EntryFee;
    private String ClassificationFee;
    private String Bond;
    private String BondUnderwritingFee;
    private String E_Manifest;
    private String CustomsISF;
    private String DutyDisbursementFee;
    private String NAFTA;
    private String ABI_Fee;
    private String DOT_EPA;
    private String ImporterRegistrationFee;
    private String OnetimePAPSExemption;
    private String AdministrationFee;
    private String GrandTotalFees;


    public String getValue() {
        return value;
    }

    public String getValueForCustoms() {
        return valueForCustoms;
    }

    public String getCustomsDuties() {
        return CustomsDuties;
    }

    public String getCustomsMPF() {
        return CustomsMPF;
    }

    public String getCustomsHMF() {
        return CustomsHMF;
    }

    public String getEntryFee() {
        return EntryFee;
    }

    public String getClassificationFee() {
        return ClassificationFee;
    }

    public String getBond() {
        return Bond;
    }

    public String getBondUnderwritingFee() {
        return BondUnderwritingFee;
    }

    public String getE_Manifest() {
        return E_Manifest;
    }

    public String getCustomsISF() {
        return CustomsISF;
    }

    public String getDutyDisbursementFee() {
        return DutyDisbursementFee;
    }

    public String getNAFTA() {
        return NAFTA;
    }

    public String getABI_Fee() {
        return ABI_Fee;
    }

    public String getDOT_EPA() {
        return DOT_EPA;
    }

    public String getImporterRegistrationFee() {
        return ImporterRegistrationFee;
    }

    public String getOnetimePAPSExemption() {
        return OnetimePAPSExemption;
    }

    public String getAdministrationFee() {
        return AdministrationFee;
    }

    public String getGrandTotalFees() {
        return GrandTotalFees;
    }


    public QuoteUSAData withValue(String value) {
        this.value = value;
        return this;
    }

    public QuoteUSAData withValueForCustoms(String valueForCustoms) {
        this.valueForCustoms = valueForCustoms;
        return this;
    }

    public QuoteUSAData withCustomsDuties(String customsDuties) {
        this.CustomsDuties = customsDuties;
        return this;
    }

    public QuoteUSAData withCustomsMPF(String customsMPF) {
        this.CustomsMPF = customsMPF;
        return this;
    }

    public QuoteUSAData withCustomsHMF(String customsHMF) {
        this.CustomsHMF = customsHMF;
        return this;
    }

    public QuoteUSAData withEntryFee(String entryFee) {
        this.EntryFee = entryFee;
        return this;
    }

    public QuoteUSAData withClassificationFee(String classificationFee) {
        this.ClassificationFee = classificationFee;
        return this;
    }

    public QuoteUSAData withBond(String bond) {
        this.Bond = bond;
        return this;
    }

    public QuoteUSAData withBondUnderwritingFee(String bondUnderwritingFee) {
        this.BondUnderwritingFee = bondUnderwritingFee;
        return this;
    }

    public QuoteUSAData withE_Manifest(String e_Manifest) {
        this.E_Manifest = e_Manifest;
        return this;
    }

    public QuoteUSAData withCustomsISF(String customsISF) {
        this.CustomsISF = customsISF;
        return this;
    }

    public QuoteUSAData withDutyDisbursementFee(String dutyDisbursementFee) {
        this.DutyDisbursementFee = dutyDisbursementFee;
        return this;
    }

    public QuoteUSAData withNAFTA(String NAFTA) {
        this.NAFTA = NAFTA;
        return this;
    }

    public QuoteUSAData withABI_Fee(String ABI_Fee) {
        this.ABI_Fee = ABI_Fee;
        return this;
    }

    public QuoteUSAData withDOT_EPA(String DOT_EPA) {
        this.DOT_EPA = DOT_EPA;
        return this;
    }

    public QuoteUSAData withImporterRegistrationFee(String importerRegistrationFee) {
        this.ImporterRegistrationFee = importerRegistrationFee;
        return this;
    }

    public QuoteUSAData withOnetimePAPSExemption(String onetimePAPSExemption) {
        this.OnetimePAPSExemption = onetimePAPSExemption;
        return this;
    }

    public QuoteUSAData withAdministrationFee(String administrationFee) {
        this.AdministrationFee = administrationFee;
        return this;
    }

    public QuoteUSAData withGrandTotalFees(String grandTotalFees) {
        this.GrandTotalFees = grandTotalFees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteUSAData usaData = (QuoteUSAData) o;
        return Objects.equals(value, usaData.value) &&
                Objects.equals(valueForCustoms, usaData.valueForCustoms) &&
                Objects.equals(CustomsDuties, usaData.CustomsDuties) &&
                Objects.equals(CustomsMPF, usaData.CustomsMPF) &&
                Objects.equals(CustomsHMF, usaData.CustomsHMF) &&
                Objects.equals(EntryFee, usaData.EntryFee) &&
                Objects.equals(ClassificationFee, usaData.ClassificationFee) &&
                Objects.equals(Bond, usaData.Bond) &&
                Objects.equals(BondUnderwritingFee, usaData.BondUnderwritingFee) &&
                Objects.equals(E_Manifest, usaData.E_Manifest) &&
                Objects.equals(CustomsISF, usaData.CustomsISF) &&
                Objects.equals(DutyDisbursementFee, usaData.DutyDisbursementFee) &&
                Objects.equals(NAFTA, usaData.NAFTA) &&
                Objects.equals(ABI_Fee, usaData.ABI_Fee) &&
                Objects.equals(DOT_EPA, usaData.DOT_EPA) &&
                Objects.equals(ImporterRegistrationFee, usaData.ImporterRegistrationFee) &&
                Objects.equals(OnetimePAPSExemption, usaData.OnetimePAPSExemption) &&
                Objects.equals(AdministrationFee, usaData.AdministrationFee) &&
                Objects.equals(GrandTotalFees, usaData.GrandTotalFees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, valueForCustoms, CustomsDuties, CustomsMPF, CustomsHMF, EntryFee, ClassificationFee, Bond, BondUnderwritingFee, E_Manifest, CustomsISF, DutyDisbursementFee, NAFTA, ABI_Fee, DOT_EPA, ImporterRegistrationFee, OnetimePAPSExemption, AdministrationFee, GrandTotalFees);
    }

    @Override
    public String toString() {
        return "QuoteUSAData{" +
                "value='" + value + '\'' +
                ", valueForCustoms='" + valueForCustoms + '\'' +
                ", CustomsDuties='" + CustomsDuties + '\'' +
                ", CustomsMPF='" + CustomsMPF + '\'' +
                ", CustomsHMF='" + CustomsHMF + '\'' +
                ", EntryFee='" + EntryFee + '\'' +
                ", ClassificationFee='" + ClassificationFee + '\'' +
                ", Bond='" + Bond + '\'' +
                ", BondUnderwritingFee='" + BondUnderwritingFee + '\'' +
                ", E_Manifest='" + E_Manifest + '\'' +
                ", CustomsISF='" + CustomsISF + '\'' +
                ", DutyDisbursementFee='" + DutyDisbursementFee + '\'' +
                ", NAFTA='" + NAFTA + '\'' +
                ", ABI_Fee='" + ABI_Fee + '\'' +
                ", DOT_EPA='" + DOT_EPA + '\'' +
                ", ImporterRegistrationFee='" + ImporterRegistrationFee + '\'' +
                ", OnetimePAPSExemption='" + OnetimePAPSExemption + '\'' +
                ", AdministrationFee='" + AdministrationFee + '\'' +
                ", GrandTotalFees='" + GrandTotalFees + '\'' +
                '}';
    }
}
