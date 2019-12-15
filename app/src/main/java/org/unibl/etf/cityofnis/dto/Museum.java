package org.unibl.etf.cityofnis.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.DrawableRes;

import org.unibl.etf.cityofnis.R;

import java.util.ArrayList;


@Entity(tableName = "museum")
public class Museum {

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

    public static ArrayList<Museum> insertMuseumData(){
        ArrayList<Museum> museumList = new ArrayList<>();

        Museum museum = new Museum();
        museum.setNameSr("Medijana");
        museum.setDescriptionSr("Priča o Medijani\n" +
                "\n" +
                "Medijana je izgrađena na levoj obali Nišave, pored jednog od najvažnijih putnih pravaca Via militaris. Nalazila se između urbanog Naisusa i termalnih izvora Niške Banje i zauzimala površinu od preko 40 hektara.\n" +
                "\n" +
                "Tokom IV veka prenaseljeni Naisus, opasan zidovima i kulama, prestaje da bude privlačno mesto za život njegovim imućnijim građanima, tako da oni sve više vremena provode na svojim imanjima na Medijani. Tamo su gradili nove ili adaptirali stare vile, koje su im služile za odmor i uživanje. Vremenom, vile menjanju svoju namenu, pa od mesta za privremeni boravak, postaju mesta za luksuzan život van grada.\n" +
                "\n" +
                "Vila sa peristilom\n" +
                "\n" +
                "Centralno mesto na Medijani zauzima vila sa peristilom, najraskošniji objekat rezidencijalnog karaktera. Vila je najverovatnije izgrađena prema nalogu rimskog cara Konstantina Velikog, kako bi sebi, članovima svoje porodice i brojnim visokim carskim službenicima stvorio uslove za boravak tokom posete Naisusu.\n" +
                "\n" +
                "Ceo kompleks vile bio je ograđen visokim zidom i zauzimo je površinu od 4,7 hektara, a sedmina ukupne površine bila je popločana mozaicima. Većina mozaika imala je dekorativne, geometrijske motive, a neki od njih se i danas mogu videti na Medijani. Dva mozaika koja su najbolje očuvana i koja privlače posebnu pažnju su mozaici sa figuralnim prikazima mitološkog, rečnog božanstva Fluviusa i glava Meduze.\n" +
                "\n" +
                "Život i privemeni boravak u vili nudio je brojne mogućnosti – od toga da su njeni gosti ovde mogli da obavljaju državničke poslove, do mogućnosti da se odmore, uživaju, i učestvuju u bogatom društvenom životu. Način života u vili slikovito dočaravaju ostaci objekata pronađeni na Medijani: sala za audijenciju, koja je predstavljala prostoriju predviđenu za obavljanje državničkih poslova ; tremovi i raskošno dekorisani vrtovi sa fontanama i paviljonima; dve manje trpezarije za koje se pretpostavlja da su služile carevima za intimnije prijeme i gozbe; terme, rimsko kupatilo, predstavljalo je deo vile koji su stanovnici Medijane koristili za negu tela i opuštanje. U termama je korišćena topla, lekovita voda koja se olovnim cevima dovodila iz Niške Banje.");
        museum.setNameEn("Mediana");
        museum.setDescriptionEn("Story about Mediana\n" +
                "\n" +
                "Mediana was built built between III and the beginning of IV century on the left bank of the Nišava River, beside one of the most important roads, Via militaris. It was located between urban Naissus and thermal springs of Niska Banja and extended over the area of 40 hectares.\n" +
                "During the 4th century, overpopulated Naissus, surrounded by walls and towers, ceased to be an attractive place for life for its wealthy citizens, so they spent most of their time in their estates in Mediana. They built there new or restored old villas which served for rest and pleasure. Over time, the villas changed their purpose, and from the places for temporary stay, they became places of luxury life outside the city.\n" +
                "\n" +
                "Villa with a peristyle\n" +
                "\n" +
                "The central place in Mediana is taken by a villa with a peristyle, the most sumptuous building of residential character. The villa was probably built by order of Emperor Constantine The Great so that he, members of his family and numerous high imperial officials would have a place to stay during their visits to Naissus. The entire complex was enclosed with high walls and was spread over the area of 4.7 hectares, and a seventh of the entire area was tiled with mosaic. Most mosaics had decorative, geometric motifs, and most of them can be still seen in Mediana today. Two mosaics that are best preserved and that draw special attention are mosaics with figural mythological representations of the river god Flavius and the head of Medusa.\n" +
                "A lifestyle in the villa is vividly evoked by the remains of the buildings found in Mediana: audience hall, which is a room designed for carrying out state affair; porches and richly decorated gardens with fountains and pavilions which were designed for social gatherings and leisure, two small dining rooms, which are assumed to have served for more private audiences and feasts of the emperors; thermae, a Roman bath, is a part of the villa that was used by residents of Mediana for body care and relaxation. Hot and healing water was used in thermae, which was brought via lead pipes from Niška Banja.");
        museum.setImage("medijana");
        museum.setLatitude(43.3084964);
        museum.setLongitude(21.9483018);
        museumList.add(museum);



        museum = new Museum();
        museum.setNameSr("Arheološka sala");
        museum.setDescriptionSr("Praistorija\n" +
                "Eksponati izloženi u Arheološkoj sali Narodnog muzeja svedoče o postojanju naseobina na teritoriji Niša od samog početka ljudskog života. Interesantni predmeti, poput keltskog mača, keramičkih posuda, figura muškaraca i žena, ogrlica od životinjskih zuba, bronzani ukrasi za kosu pronađeni na brojnim lokalitetima u Nišu i okolini prikazuju razvoj civilizacije i kulture od kamenog do gvozdenog doba.\n" +
                "\n" +
                "Antički period\n" +
                "Drugi deo arheološke postavke čine predmeti iz antičkog Naisusa i njegovog luksuznog predgrađa Medijane. Umetnička dela antičkih vajara i skulptora dominiraju ovom postavkom svojim skladom i lepotom – Jupiter na tronu, statua Asklepija – boga medicine i izlečenja, njegove kćerke Higije, skulptura boga Dionisa i njegovog pratioca Satira, snažnog Herakla, Fortune… Niš je jedan od retkih gradova u Evropi koji poseduje tri carska portreta iz perioda IV do VI veka, a to su : portret cara Konstantina u prirodnoj veličini, glava rimskog tetrarha izrađena od retkogcrvenog porfirita i glava vizantijske carice Eufemije, žene cara Justina iz VI veka. Osim umetničih dela, zbirku čini i bogata kolekcija rimskih novčića, reljefa, srebrnih tanjira iz radionice u Naisusu, raskošna ograda rimskog hrama, predmeti za hazardne igre, kao i veliki broj predmeta za svakodnevnu upotrebu.");
        museum.setNameEn("The Archaeological Hall");
        museum.setDescriptionEn("Prehistory\n" +
                "\n" +
                "In the Archaeological Hall of the National museum you can see valuable exhibits that testify about the existence of settlements at the territory of Nis from the very beginning of human life. Interesting objects, such as: Celts’ sword, ceramic vessels, female and male figures, an animal teeth neckless, bronzed hair-pins, all found on numerous locations in Nis and its surroundings, present the development of civilization and culture from the Neolithic to the Iron Age.\n" +
                "\n" +
                "Antique period\n" +
                "\n" +
                "The second section of the archaeological display consists from the objects from the period of Antique Naissus and its luxury suburbs-Mediana. The artworks of ancient sculptors stand out with their harmony and beauty : Jupiter on the throne, the statues of Asclepius-a god of medicine in ancient Greek religion, and his daughter Hygia; the sculpture of god Dionysus and his merry companion Satyr, strong Heracles, Fortuna etc. Nis is one of few cities in Europe that can be proud of 3 imperial portraits dating from IV-VI century A.D: the life-size statue of emperor Constantine the Great, the head of Roman tetrarch made of rare, red porphyry, and the head of Byzantine empress Euphemia, Justinian’s wife from VI century A.D.");
        museum.setImage("arheoloska_sala");
        museum.setLatitude(43.318378);
        museum.setLongitude(21.893252);
        museumList.add(museum);




        museum = new Museum();
        museum.setNameSr("Spomenik oslobodiocima Niša");
        museum.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Spomenik oslobodiocima smešten je u samom centru grada, na Trgu kralja Milana i obeležava razdoblje oslobodilačkih ratova protiv Osmanlijske vladavine i tokom Prvog svetskog rata.\n" +
                "\n" +
                "LOKACIJA:\n" +
                "Trg kralja Milana\n" +
                "\n" +
                "VIŠE INFORMACIJA:\n" +
                "Spomenik oslobodiocima Niša (1937) svojom lepotom i veličinom zauzima središnji deo Trga kralja Milana, centralnog trga u Nišu. Ovaj spomenik smatra se jednim od najznačajnijih dela jugoslovenske skulpture, a njen autor je Antun Augustinčić, poznati hrvatski i jugoslovenski vajar. Spomenik je podignut kao simbol oslobodilačkih ratova koji su se vodili u Nišu za vreme vladavine Osmanlijskog carstva i tokom Prvog svetskog rata. Na vrhu spomenika je konjanik sa zastavom koji simbolizuje dolazak slobode, a u srednjem delu prikazan je Stevan Sinđelić u Bici na Čegru i Kole Rašić koji poziva Nišlije na ustanak.");
        museum.setNameEn("The Monument to the Liberators of Nis");
        museum.setDescriptionEn("BASIC INFO:\n" +
                "The Monument to the Liberators of Niš (1937) with its beauty and size takes the central part of King Milan Square, the central square in Niš.  It is a symbol of liberation carried on during the time of the Ottoman rule and the World War I.\n" +
                "\n" +
                "LOCATION:\n" +
                "King Milan Square\n" +
                "\n" +
                "MORE INFO:\n" +
                "The Monument to the Liberators of Niš (1937) with its beauty and size takes the central part of King Milan Square, the central square in Niš. This monument is regarded as one of the most important works of art of the Yugoslavian sculpture art, and its author is AntunAugustunčić, a well-known Croatian and Yugoslavian sculptor. At the top of the monument is a horse rider with a flag that symbolizes the arrival of freedom, and the central part represent StevanSinđelić in the Battle of Čegar and KoleRašić calling people from Niš for uprising.");
        museum.setImage("spomenik_oslobodiocima");
        museum.setLatitude(43.321206);
        museum.setLongitude(21.895671);
        museumList.add(museum);



        museum = new Museum();
        museum.setNameSr("Spomen obeležje caru Konstantinu");
        museum.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Spomen-obeležje najznačajnijem rimskom imperatoru rođenom u Nišu simbolično je podignuto na početku mosta na Nišavi koji vodi ka Tvrđavi, u kojoj je Konstanin proveo veći deo svog detinjstva. Spomenik prikazuje lik cara Konstanina i Hristov monogram, simbol koji mu se ukazao na nebu noć pre bitke na Milvijskom mostu (312.)\n" +
                "\n" +
                "LOKACIJA:\n" +
                "na početku tvrđavskog mosta\n" +
                "\n" +
                "VIŠE INFORMACIJA:\n" +
                "Spomen obležje Konstaninu Velikom postavljeno je 3. juna 2012. godine, na dan Gradske slave Sv. car Konstantin i carica Jelena, čime je Niš ušao u red gradova od izuzetnog istorijskog značaja za razvoj hrišćanske religije (pored Karnuntuma u Austriji i Izmita u Turskoj koji imaju identična spomen obeležja). Idejni tvorac je Pjero Bordin direktor „Art Karnuntum“ fondacije iz Austrije, a spomen-obeležje je izradio niški vajar Mile Kocev.");
        museum.setNameEn("Christogram Monument");
        museum.setDescriptionEn("BASIC INFO:\n" +
                "This monument is a memorial to the most distinguished Roman emperor born in Nis (Constantine the Great). It is symbolically raised at the beginning of the bridge on the river Nisava towards the Fortress, where he spent his chilhood. The memorial presents the image of the emperor Constantine the Great and Christ’s monogram, which appeared in the sky before the Battle of the Milvian bridge (312.).\n" +
                "\n" +
                "LOCATION:\n" +
                "at the beginning of the bridge on the river Nisava towards the Fortress\n" +
                "\n" +
                "MORE INFO:\n" +
                "The monument was placed on June 3rd, 2013, on the day of the City Feast of St Emperor Constantine and Empress Helen, when Nis entered the order of cities of outstanding historical importance for the development of Christian religion (along with Carnuntum in Austria and Izmit in Turkey which possess similar memorials). The initiator of the idea is the director of ’’Art Carnuntum Foundation’’ from Austria Piero Bordin, and the memorial was sculpted by Mile Kocev, the sculptor from Nis.");
        museum.setImage("spomen_obelezje_car");
        museum.setLatitude(43.322518);
        museum.setLongitude(21.895473);
        museumList.add(museum);

        museum = new Museum();
        museum.setNameSr("Spomenik kralju Aleksandru Karađorđeviću");
        museum.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Prvobitni spomenik kralju Aleksandru, postavljen je 1939. godine, ali je već u prvim godinama po uspostavljanju komunističke vlasti u Srbiji, 1946. godine uklonjen i uništen. Novi spomenik kralju Aleksandru I Karađorđeviću podignut je 2004. godine u čast vladara koji je začetnik ideje o stvaranju Kraljevine Srba, Hrvata i Slovenaca. Spomenik je rad beogradskog vajara Zorana Ivanovića.\n" +
                "\n" +
                "LOKACIJA:\n" +
                "Trg kralja Aleksandra Karađorđevića");
        museum.setNameEn("King Aleksandar Monument");
        museum.setDescriptionEn("BASIC INFO:\n" +
                "The original monument to King Aleksandar I Karađorđević was erected in 1939, but it was removed and destroyed at the beginning of Communist rule in 1946. The new monument to King Aleksandar I Karađorđević was erected in 2004 in honor of the ruler who was the creator of the idea of the Kingdom of Serbs, Croats and Slovenes. The monument is the work of Belgrade sculptor ZoranIvanović.\n" +
                "\n" +
                "LOCATION:\n" +
                "King Aleksandar Square");
        museum.setImage("trg_kralja_aleksandra");
        museum.setLatitude(43.318128);
        museum.setLongitude(21.890872);
        museumList.add(museum);


        museum = new Museum();
        museum.setNameSr("Spomenik Stevanu Sremcu i Kalči");
        museum.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Ovaj spomenik posvećen je Stevanu Sremcu, srpskom piscu realističkih romana s kraja XX veka i njegovom prijatelju Kalči, koji je ujedno i lik iz njegovog romana Ivkova slava. Spomenik je podignut na originalnom mestu kuće Živka Mijalkovića, poznatijeg kao „gazda Ivko“, bogatog zanatlije iz Niša. Došavši sa severa Srbije, bio je očaran neposrednošću, humorom i načinom života Nišlija, naročito njihovim govorom.\n" +
                "\n" +
                "LOKACIJA:\n" +
                "početak Kopitareve ulice (Kazandžijsko sokače)\n" +
                "\n" +
                "VIŠE INFORMACIJA:\n" +
                "Stevan Sremac je voleo da se druži sa „običnim svetom“ i nalazi inspiraciju u niškim kafanama i zanatlijskim radnjama. U svojim najznačajinijm delima „Ivkova slava“ i „Zona Zamfirova“,u kojima opisuje vrline, strasti i govor ljudi sa juga,dočarao je jedan novi svet i uveo pisanje na dijalektu kao novi trend u srpskoj književnosti.\n" +
                "\n" +
                "Bronzana skulptura koja prikazuje pisca, lovca Kalču i njegovog psa Čapu delo je vajara Ivana Felkera.");
        museum.setNameEn("The Monument of Stevan Sremac and Kalca");
        museum.setDescriptionEn("BASIC INFO:\n" +
                "This monument is devoted to Stevan Sremac a famous Serbian writer and his friend Kalca, a character from his novel „Ivko’s feast’’. It was raised at the original spot of Zivko Mijalkovic’s home known as ’’gazda Ivko’’, a wealthy craftsman from Nis. Besides the fact that monument is the favourite photo spot for tourists, it also presents the tradition of people form Nis to live life to the fullest.\n" +
                "\n" +
                "LOCATION:\n" +
                "beginning of Kopitareva Street (Tinkers Alley/ Kazandzijskosokace)\n" +
                "\n" +
                "MORE INFO:\n" +
                "The bronze sculpture depicting the writer, the hunter Kalca, and his loyal companion Capa, his dog, is the work of Ivan Felker, a sculptor from Belgrade.\n" +
                "\n" +
                "In his novels’’Ivkova slava’’ and ’’Zona Zamfirova’’, Stevan Sremec described virtues, habits, passions and speech of the people from Nis. After these books had been published, written in authentic dialect, Sremac established a new trend in Serbia – writting in the colloquial language.");
        museum.setImage("sremac_i_kalca");
        museum.setLatitude(43.318182);
        museum.setLongitude(21.895122);
        museumList.add(museum);



        return museumList;
    }


}
