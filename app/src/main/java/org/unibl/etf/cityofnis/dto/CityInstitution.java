package org.unibl.etf.cityofnis.dto;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "cityinstitution")
public class CityInstitution {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nameSr")
    private String nameSr="";

    @ColumnInfo(name = "descriptionSr")
    private String descriptionSr="";

    @ColumnInfo(name = "nameEn")
    private String nameEn="";

    @ColumnInfo(name = "descriptionEn")
    private String descriptionEn="";

    @ColumnInfo(name = "image")
    private String image="";

    @ColumnInfo(name = "latitude")
    private double latitude;
    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "favourite")
    private boolean favourite;

    public int getId() {
        return id;
    }

    public String getNameSr() {
        return nameSr;
    }

    public String getDescriptionSr() {
        return descriptionSr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getImage() {
        return image;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameSr(String nameSr) {
        this.nameSr = nameSr;
    }

    public void setDescriptionSr(String descriptionSr) {
        this.descriptionSr = descriptionSr;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public static ArrayList<CityInstitution> insertCityInstitutionData(){
        ArrayList<CityInstitution> cityInstitutionList = new ArrayList<>();

        CityInstitution cityInstitution = new CityInstitution();
        cityInstitution.setNameSr("Kabinet gradonačelnika");
        cityInstitution.setDescriptionSr("OPŠTE INFORMACIJE:\n"+
               "Zgrada kabineta gradonačelnika spada u red arhitektonski najvrednijih građevina u Nišu. Izgrađena je 1925. godine prema projektu beogradskog arhitekte Aleksandra Jankovića u duhu neoklasicizma sa, dekorativnom ornamentikom i karakterističnim ulaznim delom." +
                "\n\nVIŠE INFORMACIJA:\n" +
                "Zgrada kabineta se nalazi u neposrednoj blizini nišavskog keja na mestu nekadašnjeg Kneževog dvora, letnje rezidencije kralja Milana Obrenovića. Prilikom izgradnje nove filijale Narodne banke, Knežev dvor je srušen, a na njegovom mestu podignuta je nova raskošna građevina. Karakterističan ulazni deo, timpanoni, prozorski okviri, kao i nizovi stubova svrstali su ovu zgradu u jedan od najlepših javnih objekata u Srbiji."
                );
                cityInstitution.setNameEn("The City Hall");
        cityInstitution.setDescriptionEn("BASIC INFO:\n" +
                "The City Hall is one of the architecturally most valuable buildings in Niš. It was built in 1925. in neoclassicist style, with decorative ornaments in artificial stone, and with a specifically ornamented entrance." +
                "\n\nMORE INFO:\n" +
                "It is located near the quay by the Nisava, where the Prince’s Castle, the summer residence of the prince-king Milan Obrenovic, used to be. When a new branch of the National Bank was to be built, the Princ’s Palace was demolished, and in its place a new building in the neoclassical style was erected. A characteristic entrance, decorative ornaments of artificial stone, tympana, window frames and a line of columns put this building in the group of the most beautiful public buildings in Serbia.");
        cityInstitution.setImage("kabinet_gradonacelnika");
        cityInstitution.setLatitude(43.321964);
        cityInstitution.setLongitude(21.896249);
        cityInstitutionList.add(cityInstitution);



        cityInstitution = new CityInstitution();
        cityInstitution.setNameSr("Zgrada Glavne pošte");
        cityInstitution.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Zgrada Glavne pošte nalazi se na uglu ulice Vožda Karađorđa i Orlovića Pavla i izgrađena je 1934. godine za potrebe niške filijale Državne hipotekarne banke. Beogradski arhitekta Aleksandar Đorđević projektovao je ovu dvospratnu građevinu u duhu francuske škole, u stilu akademizma." +
                "\n\nVIŠE INFORMACIJA:\n" +
                "Zgrada je postavljena ugaono, sa velikim polukružnim stepeništem na ulazu, iznad kojeg dominira reljefna kompozicija muških i ženskih figura, boga Merkura, muze umetnosti i muze arhitekture. Centralna sala u prizemlju urađena u mermeru, i sa okolnim stubovima i atrijumom predstavlja najreprezentativniji deo ovog zdanja. Nakon Drugog svetskog rata menja namenu i postaje zgrada Glavne pošte, a od 1986. godine zaštićena je kao značajan spomenik kulture.");
        cityInstitution.setNameEn("Central Post Office");
        cityInstitution.setDescriptionEn("BASIC INFO:\n" +
                "The Central Post Office was built in 1934 for the Niš branch of the National Mortgage Bank. Belgrade architect AleksandarĐorđević designed this two-storey building in the spirit of the French school in academic style" +
                "\n\nMORE INFO:\n" +
                "The building is angular with a large semicircular staircase at the entrance, above which a relief composition dominates, composed of male and female figures: god Mercury, the Muse of arts and the Muse of architecture. The central hall is done in marble and with surrounding columns and an atrium, it is the most representative part of this building. After the Second World War, its purpose was changed and it became the Central Post Office, and it has been protected as a significant monument of culture since 1986.");
        cityInstitution.setImage("zgrada_glavne_poste");
        cityInstitution.setLatitude(43.320884);
        cityInstitution.setLongitude(21.898336);
        cityInstitutionList.add(cityInstitution);



        cityInstitution = new CityInstitution();
        cityInstitution.setNameSr("Skupština grada Niša");
        cityInstitution.setDescriptionSr("Skupština grada Niša je organ odlučivanja u Nišu koji vrši osnovne funkcije lokalne vlasti, uređene Ustavom, zakonom i Statutom grada. Skupštinu čini 61 odbornik, koje biraju građani tajnim glasanjem na neposrednim izborima, na svake četiri godine. Sedište Skupštine grada Niša i Službe za poslove Skupštine grada Niša nalazi se u Ulici Nikole Pašića broj 24.\n" +
                "\n" +
                "Konstituisana je izborom predsednika Skupštine i postavljanjem sekretara Skupštine. Sednice saziva pedsednik Skupštine po potrebi, najmanje jednom u tri meseca. On je dužan da sazove Skupštinu kada to zatraži gradonačelnik, Gradsko veće ili najmanje trećina odbornika. Predsednik skupštine se bira iz reda odbornika, na predlog najmanje trećine odbornika, tajnim glasanjem na svake četiri godine.\n" +
                "\n" +
                "Stalna radna tela Skupštine su: Odbor za imenovanje, Odbor za mandatno-imunitetska pitanja, Komisija za nazive naseljenih mesta i ulica, Komisija za socijalna pitanja, Komisija za praćenje primene etničkog kodeksa, Savet za mlade i Korisnički savet javnih službi.");
        cityInstitution.setNameEn("The City Council of Nis");
        cityInstitution.setDescriptionEn("The City Council of Nis is a decision-making body in Nis that performs the basic functions of the local government, regulated by the Constitution, the law and the Statute of the city. The Assembly consists of 61 members elected by citizens by secret ballot in direct elections, every four years. The seat of the Assembly of the City of Niš and the Service for the Assembly of the City of Niš is located in Ulica Nikole Pašića 24.\n" +
                "\n" +
                "It was constituted by the election of the Speaker of the Assembly and the appointment of the Secretary of the Assembly. The session is called by the vice-president of the Assembly, if necessary, at least once in three months. He is obliged to convene the Assembly when requested by the mayor, city council or at least one third of the councilors. The President of the Assembly shall be elected from among the members of the Assembly, on the proposal of at least one third of the members of the Assembly, by a secret ballot every four years." );
        cityInstitution.setImage("skupstina_grada");
        cityInstitution.setLatitude(43.318208);
        cityInstitution.setLongitude(21.896879);
        cityInstitutionList.add(cityInstitution);


        cityInstitution = new CityInstitution();
        cityInstitution.setNameSr("Dom zdravlja");
        cityInstitution.setDescriptionSr("NAJVEĆI DOM ZDRAVLJA U ZEMLJI\n" +
                "Decenje rada i razvoja Doma zdravlja u Nišu ukazuju na matični tok zdravstva u Nišu, napore da se ono organizuje, tako da što efikasnije posluje i pruža usluge ogromnom broju stanovnika, ne samo iz Niša već i sa prostora juga Srbije.\n" +
                "\n" +
                "Vremenom je naš Dom zdravlja izrastao je u najveći zdravstveni centar u zemlji po organizacionoj, kadrovskoj strukturi i mreži sa posledičnim nivoom usluga. O tome svedoči deset organizacionih jedinica koje funkcionišu u centralnom objektu i oko šezdeset punktova u gradu i selima, zavidni kadrovski nivo sa velikim brojem specijalista, primarijusa, magistara i doktora nauka, što potkrepljuje tvrdnju da je Dom zdravlja naučno - nastavna baza Medicinskog fakulteta.\n" +
                "\n" +
                "Trajan je zadatak i stalna i kontinuirana edukacija zdravstvenih radnika, uz adekvatno opremanje savremenim medicinskim aparatima, kao i pružanje visoko kavlitetnih zdravstvenih usluga.");
        cityInstitution.setNameEn("Health center");
        cityInstitution.setDescriptionEn("THE LARGEST HEALTH CENTER IN THE COUNTRY\n" +
                "The decoration of the work and development of the Health Center in Niš point to the mainstream of health in Niš, efforts to organize it, so that it operates more efficiently and provides services to a huge number of inhabitants, not only from Nis, but also from the south of Serbia.\n" +
                "\n" +
                "Over time, our Health Center grew into the largest health center in the country by organizational, personnel structure and network with the consequent level of service. This is evidenced by the ten organizational units that function in the central facility and around sixty points in the city and villages, an enviable staffing level with a large number of specialists, primaries, magicians and doctors of science, which supports the claim that the Health Center is a scientific and teaching base of the Faculty of Medicine.\n" +
                "\n" +
                "The permanent and continuous education of health workers is a permanent task, with adequate equipment for modern medical devices, as well as providing high quality health services.");
        cityInstitution.setImage("dom_zdravlja");
        cityInstitution.setLatitude(43.322774);
        cityInstitution.setLongitude(21.907935);
        cityInstitutionList.add(cityInstitution);


        cityInstitution = new CityInstitution();
        cityInstitution.setNameSr("Glavna policijska stanica Niš");
        cityInstitution.setDescriptionSr("Policijska uprava Niša omogućava građanima da dobiju sve neophodne usluge kao što su lična dokumenta – lične karte i pasoši, ali i sve drugo što im je potrebno.");
        cityInstitution.setNameEn("The main police station of the Nis");
        cityInstitution.setDescriptionEn("The Police Administration of Nis enables citizens to obtain all necessary services, such as personal documents - identity cards and passports, as well as everything else they need.");
        cityInstitution.setImage("policijska_stanica");
        cityInstitution.setLatitude(43.319406);
        cityInstitution.setLongitude(21.896511);
        cityInstitutionList.add(cityInstitution);

        return cityInstitutionList;
    }



}
