package net.jfuentestgn.enslocals.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "ens_locals")
public class EnsLocalEntity {

    private static final Logger log = LoggerFactory.getLogger(EnsLocalEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "CODI_10", nullable = false, unique = true)
    @Size(min = 10, max = 10, message = "Code must be exactly 10 chars long")
    private String codi10;

    @NotNull
    @Column(name = "ORDENACIO_ALFABETICA", nullable = false, unique = false)
    private String ordenacioAlfabetica;

    @NotNull
    @Column(name = "NOM_COMPLERT", nullable = false, unique = true)
    private String nomComplert;

    @Column(name = "ADRECA")
    private String adreça;

    private String municipi;

    private String telèfon;

    private String fax;

    private String tractament;

    private String president;

    private String nomPresident;

    private String cognom1President;

    private String cognom2President;

    private String partitPolitic;

    private String sexe;

    private String càrrec;

    private String gerent;

    private Boolean capitalComarca;

    private String cif;

    private String comarca;

    @Size(min = 10, max = 10, message = "'CodComarca' must be exactly 10 chars long")
    private String codComarca;

    private String provincia;

    @Size(min = 10, max = 10, message = "'CodiProv' must be exactly 10 chars long")
    private String codiProv;

    private Integer anyCens;

    private Integer cens;

    private Integer codiTipus;

    private Float superficie;

    private String article;

    private String nomtipus;

    @Size(min = 5, max = 5, message = "'CodiPostal' must be exactly 5 chars long")
    private String codiPostal;

    private String secretari;

    private String horari;

    private Boolean dissolt;

    private String siglaCom;

    private Integer altura;

    private String codiPare;

    private String tipusPare;

    private String nomPare;

    @Column(name = "HD", nullable = true)
    private String hd;

    private String nomCapital;

    private String eMail;

    private String web;

    private String partitJudicial;

    private String partitElectoral;

    private String gentilici;

    private String localitatCp;

    private String delegacioGovern;

    private String municat;

    private String ambit;

    private String situaGeoMunicipi;

    private String situaGeoComarca;

    private String planolCarrers;

    private String salutacio;

    private Date dataActualitzacio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodi10() {
        return codi10;
    }

    public void setCodi10(String codi10) {
        this.codi10 = codi10;
    }

    public String getOrdenacioAlfabetica() {
        return ordenacioAlfabetica;
    }

    public void setOrdenacioAlfabetica(String ordenacioAlfabetica) {
        this.ordenacioAlfabetica = ordenacioAlfabetica;
    }

    public String getNomComplert() {
        return nomComplert;
    }

    public void setNomComplert(String nomComplert) {
        this.nomComplert = nomComplert;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public String getTelèfon() {
        return telèfon;
    }

    public void setTelèfon(String telèfon) {
        this.telèfon = telèfon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTractament() {
        return tractament;
    }

    public void setTractament(String tractament) {
        this.tractament = tractament;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getNomPresident() {
        return nomPresident;
    }

    public void setNomPresident(String nomPresident) {
        this.nomPresident = nomPresident;
    }

    public String getCognom1President() {
        return cognom1President;
    }

    public void setCognom1President(String cognom1President) {
        this.cognom1President = cognom1President;
    }

    public String getCognom2President() {
        return cognom2President;
    }

    public void setCognom2President(String cognom2President) {
        this.cognom2President = cognom2President;
    }

    public String getPartitPolitic() {
        return partitPolitic;
    }

    public void setPartitPolitic(String partitPolitic) {
        this.partitPolitic = partitPolitic;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCàrrec() {
        return càrrec;
    }

    public void setCàrrec(String càrrec) {
        this.càrrec = càrrec;
    }

    public String getGerent() {
        return gerent;
    }

    public void setGerent(String gerent) {
        this.gerent = gerent;
    }

    public Boolean getCapitalComarca() {
        return capitalComarca;
    }

    public void setCapitalComarca(Boolean capitalComarca) {
        this.capitalComarca = capitalComarca;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getCodComarca() {
        return codComarca;
    }

    public void setCodComarca(String codComarca) {
        this.codComarca = codComarca;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(String codiProv) {
        this.codiProv = codiProv;
    }

    public Integer getAnyCens() {
        return anyCens;
    }

    public void setAnyCens(Integer anyCens) {
        this.anyCens = anyCens;
    }

    public Integer getCens() {
        return cens;
    }

    public void setCens(Integer cens) {
        this.cens = cens;
    }

    public Integer getCodiTipus() {
        return codiTipus;
    }

    public void setCodiTipus(Integer codiTipus) {
        this.codiTipus = codiTipus;
    }

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getNomtipus() {
        return nomtipus;
    }

    public void setNomtipus(String nomtipus) {
        this.nomtipus = nomtipus;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }

    public String getSecretari() {
        return secretari;
    }

    public void setSecretari(String secretari) {
        this.secretari = secretari;
    }

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public Boolean getDissolt() {
        return dissolt;
    }

    public void setDissolt(Boolean dissolt) {
        this.dissolt = dissolt;
    }

    public String getSiglaCom() {
        return siglaCom;
    }

    public void setSiglaCom(String siglaCom) {
        this.siglaCom = siglaCom;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getCodiPare() {
        return codiPare;
    }

    public void setCodiPare(String codiPare) {
        this.codiPare = codiPare;
    }

    public String getTipusPare() {
        return tipusPare;
    }

    public void setTipusPare(String tipusPare) {
        this.tipusPare = tipusPare;
    }

    public String getNomPare() {
        return nomPare;
    }

    public void setNomPare(String nomPare) {
        this.nomPare = nomPare;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getNomCapital() {
        return nomCapital;
    }

    public void setNomCapital(String nomCapital) {
        this.nomCapital = nomCapital;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPartitJudicial() {
        return partitJudicial;
    }

    public void setPartitJudicial(String partitJudicial) {
        this.partitJudicial = partitJudicial;
    }

    public String getPartitElectoral() {
        return partitElectoral;
    }

    public void setPartitElectoral(String partitElectoral) {
        this.partitElectoral = partitElectoral;
    }

    public String getGentilici() {
        return gentilici;
    }

    public void setGentilici(String gentilici) {
        this.gentilici = gentilici;
    }

    public String getLocalitatCp() {
        return localitatCp;
    }

    public void setLocalitatCp(String localitatCp) {
        this.localitatCp = localitatCp;
    }

    public String getDelegacioGovern() {
        return delegacioGovern;
    }

    public void setDelegacioGovern(String delegacioGovern) {
        this.delegacioGovern = delegacioGovern;
    }

    public String getMunicat() {
        return municat;
    }

    public void setMunicat(String municat) {
        this.municat = municat;
    }

    public String getAmbit() {
        return ambit;
    }

    public void setAmbit(String ambit) {
        this.ambit = ambit;
    }

    public String getSituaGeoMunicipi() {
        return situaGeoMunicipi;
    }

    public void setSituaGeoMunicipi(String situaGeoMunicipi) {
        this.situaGeoMunicipi = situaGeoMunicipi;
    }

    public String getSituaGeoComarca() {
        return situaGeoComarca;
    }

    public void setSituaGeoComarca(String situaGeoComarca) {
        this.situaGeoComarca = situaGeoComarca;
    }

    public String getPlanolCarrers() {
        return planolCarrers;
    }

    public void setPlanolCarrers(String planolCarrers) {
        this.planolCarrers = planolCarrers;
    }

    public String getSalutacio() {
        return salutacio;
    }

    public void setSalutacio(String salutacio) {
        this.salutacio = salutacio;
    }

    public Date getDataActualitzacio() {
        return dataActualitzacio;
    }

    public void setDataActualitzacio(Date dataActualitzacio) {
        this.dataActualitzacio = dataActualitzacio;
    }

    @Transient
    public void setField(String name, String value) throws ParseException {
        switch (name) {
            case "CODI_10":
                if (value.length() == 9) {
                    value = "0" + value;
                }
                this.setCodi10(value);
                break;
            case "ORDENACIO_ALFABETICA":
                this.setOrdenacioAlfabetica(value);
                break;
            case "NOM COMPLERT":
                this.setNomComplert(value);
                break;
            case "ADREÇA":
                this.setAdreça(value);
                break;
            case "MUNICIPI":
                this.setMunicipi(value);
                break;
            case "TELÈFON":
                this.setTelèfon(value);
                break;
            case "FAX":
                this.setFax(value);
                break;
            case "TRACTAMENT":
                this.setTractament(value);
                break;
            case "PRESIDENT":
                this.setPresident(value);
                break;
            case "NOM":
                this.setNomPresident(value);
                break;
            case "COGNOM1":
                this.setCognom1President(value);
                break;
            case "COGNOM2":
                this.setCognom2President(value);
                break;
            case "PARTIT_POLITIC":
                this.setPartitPolitic(value);
                break;
            case "SEXE":
                this.setSexe(value);
                break;
            case "CÀRREC":
                this.setCàrrec(value);
                break;
            case "GERENT":
                this.setGerent(value);
                break;
            case "CIF":
                this.setCif(value);
                break;
            case "COMARCA":
                this.setComarca(value);
                break;
            case "CODCOMARCA":
                this.setCodComarca(value);
                break;
            case "PROVINCIA":
                this.setProvincia(value);
                break;
            case "CODIPROV":
                this.setCodiProv(value);
                break;
            case "CAPICOM":
                Boolean bool = this.parseBoolean(value);
                this.setCapitalComarca(bool);
                break;
            case "ANY_CENS":
                this.setAnyCens(this.parseIntValue(value));
                break;
            case "CENS":
                this.setCens(this.parseIntValue(value));
                break;
            case "CODITIPUS":
                this.setCodiTipus(this.parseIntValue(value));
                break;
            case "SUPERFICIE":
                Float flt = this.parseFloat(value);
                this.setSuperficie(flt);
                break;
            case "ARTICLE":
                this.setArticle(value);
                break;
            case "NOMTIPUS":
                this.setNomtipus(value);
                break;
            case "CODIPOSTAL":
                if (value.length() == 4) {
                    value = "0" + value;
                }
                this.setCodiPostal(value);
                break;
            case "SECRETARI":
                this.setSecretari(value);
                break;
            case "HORARI":
                this.setHorari(value);
                break;
            case "DISSOLT":
                this.setDissolt(this.parseBoolean(value));
                break;
            case "SIGLACOM":
                this.setSiglaCom(value);
                break;
            case "ALTURA":
                this.setAltura(this.parseIntValue(value));
                break;
            case "CODIPARE":
                this.setCodiPare(value);
                break;
            case "TIPUSPARE":
                this.setTipusPare(value);
                break;
            case "NOMPARE":
                this.setNomPare(value);
                break;
            case "HD":
                this.setHd(value);
                break;
            case "NOM_CAPITAL":
                this.setNomCapital(value);
                break;
            case "E_MAIL":
                this.setEMail(value);
                break;
            case "WEB":
                this.setWeb(value);
                break;
            case "PARTIT_JUDICIAL":
                this.setPartitJudicial(value);
                break;
            case "PARTIT_ELECTORAL":
                this.setPartitElectoral(value);
                break;
            case "GENTILICI":
                this.setGentilici(value);
                break;
            case "LOCALITAT_CP":
                this.setLocalitatCp(value);
                break;
            case "DELEGACIO_GOVERN":
                this.setDelegacioGovern(value);
                break;
            case "MUNICAT":
                this.setMunicat(value);
                break;
            case "AMBIT":
                this.setAmbit(value);
                break;
            case "SITUA_GEO_MUNICIPI":
                this.setSituaGeoMunicipi(value);
                break;
            case "SITUA_GEO_COMARCA":
                this.setSituaGeoComarca(value);
                break;
            case "PLANOL_CARRERS":
                this.setPlanolCarrers(value);
                break;
            case "SALUTACIO":
                this.setPlanolCarrers(value);
                break;
            case "DATA_ACTUALITZACIO":
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// HH:mm:ss");
                Date date = sdf.parse(value);
                this.setDataActualitzacio(date);
                break;
            default:
                log.error("Field not found: " + name + " - Value = [" + value + "]");
        }
    }

    private Float parseFloat(String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        value = value.replaceAll(",", ".");
        return Float.parseFloat(value);
    }

    private Boolean parseBoolean(String value) throws ParseException {
        if (value == null || value.equals("")) {
            return null;
        }
        if ("S".equals(value)) {
            return Boolean.TRUE;
        }
        if ("N".equals(value)) {
            return Boolean.FALSE;
        }

        throw new ParseException("Incorrect value for boolean field: " + value, 0);
    }

    private Integer parseIntValue(String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        return Integer.parseInt(value);
    }
}
