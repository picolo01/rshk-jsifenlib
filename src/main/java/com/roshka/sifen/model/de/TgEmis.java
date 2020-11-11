package com.roshka.sifen.model.de;

import com.roshka.sifen.model.NamespacesConstants;
import com.roshka.sifen.model.de.types.TTipReg;
import com.roshka.sifen.model.de.types.TiTipCont;
import com.roshka.sifen.model.departamentos.TDepartamento;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import java.util.List;

public class TgEmis {
    private String dRucEmi;
    private short dDVEmi;
    private TiTipCont iTipCont;
    private TTipReg cTipReg;    // optional
    private String dNomEmi;
    private String dNomFanEmi;
    private String dDirEmi;
    private int dNumCas;
    private String dCompDir1;
    private String dCompDir2;
    private TDepartamento cDepEmi;
    private short cDisEmi;
    private String dDesDisEmi;
    private int cCiuEmi;
    private String dDesCiuEmi;
    private String dTelEmi;
    private String dEmailE;
    private String dDenSuc;
    private List<TgActEco> gActEcoList;
    private TgRespDE gRespDE;

    public void setupSOAPElements(SOAPElement gDatGralOpe) throws SOAPException {
        SOAPElement gEmis = gDatGralOpe.addChildElement("gEmis", NamespacesConstants.SIFEN_NS_PREFIX);
        gEmis.addChildElement("dRucEm", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dRucEmi);
        gEmis.addChildElement("dDVEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.dDVEmi));
        gEmis.addChildElement("iTipCont", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.iTipCont.getVal()));
        if (this.cTipReg != null)
            gEmis.addChildElement("cTipReg", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.cTipReg.getVal()));
        gEmis.addChildElement("dNomEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dNomEmi);
        if (this.dNomFanEmi != null)
            gEmis.addChildElement("dNomFanEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dNomFanEmi);
        gEmis.addChildElement("dDirEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dDirEmi);
        gEmis.addChildElement("dNumCas", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.dNumCas));
        if (dCompDir1 != null)
            gEmis.addChildElement("dCompDir1", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dCompDir1);
        if (dCompDir2 != null)
            gEmis.addChildElement("dCompDir2", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dCompDir2);
        gEmis.addChildElement("cDepEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.cDepEmi.getVal()));
        gEmis.addChildElement("dDesDepEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.cDepEmi.getDescripcion());

        if (this.cDisEmi != 0) {
            gEmis.addChildElement("cDisEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.cDisEmi));
            gEmis.addChildElement("dDesDisEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dDesDisEmi);
        }
        gEmis.addChildElement("cCiuEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(String.valueOf(this.cCiuEmi));
        gEmis.addChildElement("dDesCiuEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dDesCiuEmi);
        gEmis.addChildElement("dTelEmi", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dTelEmi);
        gEmis.addChildElement("dEmailE", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dEmailE);

        if (this.dDenSuc != null)
            gEmis.addChildElement("dDenSuc", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(this.dDenSuc);

        for (TgActEco gActEco : this.gActEcoList) {
            SOAPElement gActEcoElement = gEmis.addChildElement("gActEco", NamespacesConstants.SIFEN_NS_PREFIX);
            gActEcoElement.addChildElement("cActEco", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(gActEco.getcActEco());
            gActEcoElement.addChildElement("dDesActEco", NamespacesConstants.SIFEN_NS_PREFIX).setTextContent(gActEco.getdDesActEco());
        }

        if (gRespDE != null) this.gRespDE.setupSOAPElements(gEmis);
    }

    public String getdRucEmi() {
        return dRucEmi;
    }

    public void setdRucEmi(String dRucEmi) {
        this.dRucEmi = dRucEmi;
    }

    public short getdDVEmi() {
        return dDVEmi;
    }

    public void setdDVEmi(short dDVEmi) {
        this.dDVEmi = dDVEmi;
    }

    public TiTipCont getiTipCont() {
        return iTipCont;
    }

    public void setiTipCont(TiTipCont iTipCont) {
        this.iTipCont = iTipCont;
    }

    public TTipReg getcTipReg() {
        return cTipReg;
    }

    public void setcTipReg(TTipReg cTipReg) {
        this.cTipReg = cTipReg;
    }

    public String getdNomEmi() {
        return dNomEmi;
    }

    public void setdNomEmi(String dNomEmi) {
        this.dNomEmi = dNomEmi;
    }

    public String getdNomFanEmi() {
        return dNomFanEmi;
    }

    public void setdNomFanEmi(String dNomFanEmi) {
        this.dNomFanEmi = dNomFanEmi;
    }

    public String getdDirEmi() {
        return dDirEmi;
    }

    public void setdDirEmi(String dDirEmi) {
        this.dDirEmi = dDirEmi;
    }

    public int getdNumCas() {
        return dNumCas;
    }

    public void setdNumCas(int dNumCas) {
        this.dNumCas = dNumCas;
    }

    public String getdCompDir1() {
        return dCompDir1;
    }

    public void setdCompDir1(String dCompDir1) {
        this.dCompDir1 = dCompDir1;
    }

    public String getdCompDir2() {
        return dCompDir2;
    }

    public void setdCompDir2(String dCompDir2) {
        this.dCompDir2 = dCompDir2;
    }

    public TDepartamento getcDepEmi() {
        return cDepEmi;
    }

    public void setcDepEmi(TDepartamento cDepEmi) {
        this.cDepEmi = cDepEmi;
    }

    public short getcDisEmi() {
        return cDisEmi;
    }

    public void setcDisEmi(short cDisEmi) {
        this.cDisEmi = cDisEmi;
    }

    public String getdDesDisEmi() {
        return dDesDisEmi;
    }

    public void setdDesDisEmi(String dDesDisEmi) {
        this.dDesDisEmi = dDesDisEmi;
    }

    public int getcCiuEmi() {
        return cCiuEmi;
    }

    public void setcCiuEmi(int cCiuEmi) {
        this.cCiuEmi = cCiuEmi;
    }

    public String getdDesCiuEmi() {
        return dDesCiuEmi;
    }

    public void setdDesCiuEmi(String dDesCiuEmi) {
        this.dDesCiuEmi = dDesCiuEmi;
    }

    public String getdTelEmi() {
        return dTelEmi;
    }

    public void setdTelEmi(String dTelEmi) {
        this.dTelEmi = dTelEmi;
    }

    public String getdEmailE() {
        return dEmailE;
    }

    public void setdEmailE(String dEmailE) {
        this.dEmailE = dEmailE;
    }

    public String getdDenSuc() {
        return dDenSuc;
    }

    public void setdDenSuc(String dDenSuc) {
        this.dDenSuc = dDenSuc;
    }

    public List<TgActEco> getgActEcoList() {
        return gActEcoList;
    }

    public void setgActEcoList(List<TgActEco> gActEcoList) {
        this.gActEcoList = gActEcoList;
    }

    public TgRespDE getgRespDE() {
        return gRespDE;
    }

    public void setgRespDE(TgRespDE gRespDE) {
        this.gRespDE = gRespDE;
    }
}
