package org.unibl.etf.cityofnis.dto;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "adventure")
public class Adventure {
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

    public static ArrayList<Adventure> insertAdventureData(){
        ArrayList<Adventure> adventureList = new ArrayList<>();

        Adventure adventure = new Adventure();
        adventure.setNameSr("Speleologija ");
        adventure.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Ukoliko ste ljubitelj podzemnog sveta, onda su pećine u okolini Niša pravi izazov za Vas. Istražite kanale, doživite potpuno iznenađujuća otkrića i upoznajte njihove skrivene lepote: pećinski nakit, draperije, dvorane, heliktite i pećinske ruže. Društvo će Vam praviti slepi miševi i vatreni daždevnjaci, počasni stanovnici pećina.\n" +
                "\n" +
                "Upoznajte podzemni svet Svrljiških planina i posetite Cerjansku pećinu, pećinu Samar, Popšičku, Prekonošku pećinu i ostale pećine u okolini.");
        adventure.setNameEn("Speleology");
        adventure.setDescriptionEn("BASIC INFO:\n" +
                "If you’re the lover of the underground world, then the caves in the surroundings of Nis are a right challenge for you: explore the channels, experience completely extraordinary discoveries, meet their hidden beauties: speleothemes, draperies, halls, helictites…\n" +
                "Get acquainted with the underground world of Svrljig mountains, and pay a visit to Cerje, Samar, Popsica, Prekonoga and other caves.");
        adventure.setImage("speleologija");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);

         adventure = new Adventure();
        adventure.setNameSr("Jeep safari");
        adventure.setDescriptionSr("JEEP SAFARI PROGRAMI:\n" +
                "SUVA PLANINA OFF ROAD 4X4 je avanturistički program namenjen ljubiteljima avanture, prirode i terenskih automobila. Za izvođenje ovog programa koristi se splet nekadašnjih vojnih i drugih puteva. Vozeći džip upoznaćete najlepše delove Suve planine, kao i istoriju, tradiciju i kulturu stanovnika ovog kraja\n" +
                "SELIČEVICA OFF ROAD 4X4 je jednodnevni sportsko-turistički program obilaska planine Seličevice i upoznavanja sa istorijom i kulturom ovog kraja. Obilaze se: Gabrovački manastir, kućna etnografska zbirka u selu Vukmanovo, najviši vrh planine Velika Tumba (vidikovac i repetitorski stub), rimske grobnice, poznato srednjevekovno utvrđenje „Korvin grad“ i Crkva Sv. Jovana. Distanca: 50 do 100 km\n" +
                "KALAFAT OFF ROAD 4X4 je sportsko–turistički program upoznavanja brdsko-planinskog prostora severno od Niša. Ovaj prostor predstavlja jedan od najvećih speleoloških potencijala na prostoru Balkana, pravu riznicu prirodnjačkih vrednosti i kulturno-istorijskih spomenika.\n" +
                "SVRLJIŠKE PLANINE OFF ROAD 4X4 predstavlja jednodnevnu ili dvodnevnu avanturu koja vodi preko planinskog lanca Svrljiških planina, Gulijanskih planina i Rinjske planina. Najviša tačka na ovom planinskom vencu je na Gulijanskoj planini – Zeleni vrh (1.334 mnv). Nekada je po sredini ovog planinskog venca išla granica između Otomanskog carstva i Srbije, pa se na nekim mestima još uvek mogu naći ostaci graničnih karaula. Prostor obiluje pećinama i vrtačama, od kojih je najpoznatija Prekonoška pećina. Kod sela Periša nalazi se neobična prirodna retkost, gde reka Svrljiški Timok na ulazu u selo postaje ponornica, da bi se jedan kilometar nizvodno ponovo pojavila na površini. Za izvođenje ovog programa koristi se splet nekadašnjih vojnih i drugih puteva ali i ostalih prolaza i staza. Distanca: 50 do 150 km");
        adventure.setNameEn("Jeep safari");
        adventure.setDescriptionEn("Jeep Safari Programs:\n" +
                "SUVA MOUNTAIN OFF ROAD 4×4 is an one day or two days adventure program intended for the lovers of adventure, nature and SUVs. For this program’s performance it’s used a net of former miltary and other roads; the goal of this project is to present the most alluring landscapes of Suva mountain, its history, tradition and culture.\n" +
                "SELICEVICA OFF ROAD 4X4 is a one day sports and tourist program of visiting the mountain Selicevica and getting acquainted with the history and culture of this region. The tour includes: the Monastery of Gabrovac, ethnographic collection in Vukmanovo, the highest peak of the mountain Velika Tumba- viewpoint and relay, Roman tombs, a well-known fortification Korvin grad, the Church of St John. Distance: 50-100 km\n" +
                "KALAFAT OFF ROAD 4X4 sports and tourist program tour of the region North from Nis. This area represents one of the greatest speleological potentials in the Balkans, a genuine treasury of the natural values and cultural and historical potentials.\n" +
                "SVRLJIG MOUNTAINS OFF ROAD 4×4 is a one day or a two day adventure program over the mountain chain composed of : Svrljig, Gulijan and Rinj mountains. The highest point in this range is situated on Gulijan mountain-Zeleni vrh (1.334 m). Svrljig mountains are mostly forested but little researched in the biomorphological sense, but also from the cultural and historical aspect. The area is rich in caves and sinkholes , of which the most famous is Prekonoga cave. The program is conveyed on the former military and other roads and tracks. Distance: 50-100 km.");
        adventure.setImage("jeep_safari");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);


         adventure = new Adventure();
        adventure.setNameSr("Planinarenje");
        adventure.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Lepotu prirode najbolje ćete spoznati pešačenjem i planinarenjem. Za ovakvu vrstu aktivnosti ne morate da budete profesinalac, a korist je višestruka i rekreacija i uživanje u prirodnim lepotama. Jedini protiv koga ćete se takmičiti dok se penjete ka vrhu ste Vi sami.\n" +
                "\n" +
                "Naučite da uživate u prirodi i da je poštujete i videćete koliko ona može da pruži. Planine u okolini Niša Suva planina, Svrljiške planine, Kalafat i Seličevica Vam pored rekreacije i uživanja u prirodnim lepotama i retkostima pružaju i mogućnost da se upoznate sa kulturno-istorijskim nasleđem ovog kraja.\n" +
                "\n" +
                "PREPORUČUJEMO OBILAZAK SLEDEĆIH STAZA:\n" +
                "Obilazak Seličevice: Niš – Velika Tumba – Koritnik (KT01 – KT03) – dužina trase: 31.5 km, uspon 1.400 m, spust 1.000 m;\n" +
                "Grebenska tura na Suvoj planini: Koritnik – Mosor – Trem – Sokolov kamen – Pasarelo (KT03 –KT07) – dužina trase: 29 km, uspon 2.180 m, spust 1.370 m;\n" +
                "Najbolji vidikovci: Pasarelo – Divna Gorica – Krupac (KT07 – KT08) – dužina staze: 22.5 km, uspon 700 m, spust 1.900 m;\n" +
                "Obilazak Svrljiških planina: Krupac – Svrljiške planine – Oreovac (KT09 – KT011) – dužina staze: 29 km, uspon 2.070 m, spust 1.680 m;\n" +
                " Obilazak planine Kalafat: Oreovac – Kalafat – Kamenički vis – Niš (KT12 – KT01) – dužina staze: 31 km, uspon 800 m, spust 1.200 m;\n" +
                "Suva planina- staza ka najvišem vrhu Trem: Bojanine vode – Trem 1.809m – ukupna dužina staze: 14 km, visinska razlika: 1.900 mnv, najniža tačka: 864 m, najviša tačka: 1.809 m, potrebno vreme za prelazak staze: 6 – 8 sati.");
        adventure.setNameEn("Mountaineering");
        adventure.setDescriptionEn("BASIC INFO:\n" +
                "The best way to perceive the beauties of nature is hiking and mountaineering. The mountains in the surroundings of Nis- Suva, Svrljig, Kalafat and Selicevica, except for the recreation and enjoyment in natural beauty and rarities, will provide you with a possibility to get acquainted with cultural and historical heritage of this region.\n" +
                "\n" +
                "We recommend the tour of the following tracks:\n" +
                "Selicevica tour: Nis- Velika Tumba- Koritnik ( KT01-KT03)-Length of the track: 31.5 km, ascent 1400 m; descent 1000 m;\n" +
                "Ridge tour on Suva mountain: Koritnik-Mosor Trem-Sokolov kamen-Passarelo(KT03-KT07)-length of the track: 29 km, ascent: 2.180 m, descent 1.370 m;\n" +
                "The best view points: Pasarelo- Divna Gorica- Krupac (KT07-KT08)-length of the track: 22.5 km, ascent 700 m, descent 1.900 m;\n" +
                "Svrljig mountains tour: Krupac- Svrljig mountains- Oreovac (KT09-KT011)-length of the track: 29 km,ascent: 2.070 m, descent 1.680 m;\n" +
                "Kalafat mountain tour: Oreovac-Kalafat-Kamenica hill- Nis (KT12-KT01)-length of the track: 31 km, ascent 800 m, descent 1.200 m;\n" +
                "Towards the highest peak of Suva mountain: Bojanine vode- Trem 1.809 m-total length of the track: 14 km, height difference: 1.900 m, lowest point: 564 m, highest point: 1.809 m, required time: 6-8 h.");
        adventure.setImage("planinarenje");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);


         adventure = new Adventure();
        adventure.setNameSr("Paraglajding");
        adventure.setDescriptionSr("OPŠTE INFORMACIJE:\n" +

                "Paraglajding Vam pruža izuzetan osećaj slobode, podiže adrenalin i pruža nesvakidašnji pogled na prirodne lepote iz „ptičje perspektive“. Uz iskusne instuktore i korišćenje sigurnosne opreme rizik ovog sporta smanjen je na minimum.\n" +
                "\n" +
                "Tereni:\n" +
                "\n" +
                "Za početnike preporučujemo poletište Koritnik, 4 km od centra Niške Banje, a 15 km od Niša. Poletište se nalazi na 550 mnv, dok je sletanje na 220 mnv. Do poletišta je moguće stići putničkim automobilom\n" +
                " Za one koji vole da pomeraju granice straha preporučujemo poletište Višegrad, koje se nalazi na 20 km od Niša, iznad sela Sićevo. Od sela Oreovac makadamski put vodi do poletišta koje se nalazi na 1.020 mnv, a sletanje je na 320 mnv. Poletište Višegrad se smatra jednim od najboljih terena u Evropi, pa se na ovom terenu organizuju državna, evropska i svetska takmičenja od 1995. godine.\n" +
                "Zanimljivosti:\n" +
                "\n" +
                "Nišavska kotlina okružena planinskim vencima, predstavlja idealan teren za paraglajding. Povoljni vetrovi i dobri klimatski uslovi dodatno pogoduju da se na terenima u okolini Niša već nekoliko godina za redom održavaju svetska i evropska takmičenja.\n" +
                "Najbolji period za letenje je od maja do septembra, mada je moguće leteti tokom cele godine.\n" +
                "Na terenu Višegrad, član niškog paraglajding kluba “Grunf”, Miroljub Janićijević, postigao je visinski rekord sa visinom od 3.600 m.");
        adventure.setNameEn("Paragliding");
        adventure.setDescriptionEn("BASIC INFO:\n" +

                "Paragliding tandem flight gives you a unique sense of freedom, raises adrenaline and provides an extraordinary view on natural beauties from ’’the bird’s-eye view’’.\n" +
                "\n" +
                "Terrains:\n" +
                "\n" +
                "For the beginners we recommend the take off on Koritnik, 4 km from Niska Banja downtown, 15 km from Nis. By a passenger vehicle it’s possible to reach the start at 550 m, while the landing is on the height of 220 m.\n" +
                "The dare devils can try the take off Visegrad, 20 km from Nis towards East, over Sicevo village. The road leads to the peak Visegrad- the starting point is on 1.020 m, landing point on 320 m. At this take off the competitions have been organized since 1995.\n" +
                "Interesting  facts:\n" +
                "\n" +
                "The valley of Nis surrounded by mountain ranges represents an ideal terrain for paragliding. Favourable winds and good climate conditions of the Nis surroundings are fit for organizing European and world competition (National Championship in Paragliding 1997; The Third World Championship 2005; World Cup in Flight in Sicevo, two First category competitions in Landing and Flight in 2008, Paragliding World Cup 2017. )\n" +
                "The best period for flying is from May till September, although it’s possible to fly throughout the whole year.\n" +
                "On the terrain of Visegrad, Miroljub Janicijevic, a member of paragliding club ’’Grunf’’ from Nis, achived a height record of 3.600 m.");
        adventure.setImage("paragliding");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);

        adventure = new Adventure();
        adventure.setNameSr("Slobodno penjanje");
        adventure.setDescriptionSr("PRIRODNE STENE:\n" +
                "Jelašnička klisura je prvo penjalište u Srbiji posvećeno samo sportskom penjanju. Od prvih smerova koji su nastali 1994/95 pa do danas su svi opremljeni za sportsko penjanje. Stena je oštar dolomitski krečnjak i svojom belinom daje pravi kontrast okolnom zelenilu. Zbog mikroklime i orijentacije stena, najbolje vreme za penjanje je proleće i jesen.\n" +
                "Trenutno u Jelašničkoj klisuri postoji preko 200 smerova težine od 4b do 8b (Fr.) i oko 250 bolder problema težine od 3A do 7C (Fr.).\n" +
                "Broj smerova: 208 (4b-8b Fr.)\n" +
                "Broj boldera: 244 (3A-7C Fr.) .Ocene: od 5a do 8b+\n" +
                "Sićevačka klisura je do 2010. godine bila rezervisana samo za ljubitelje tradicionalnog penjanja. Nakon održanog takmičenja “Naissus route climbing challenge 04”, kada je opremljeno oko 20 smerova, Sićevo počinju da posećuju i sportski penjači. Stena je južno orijentisana, te je idealan period za penjanje proleće, jesen, ali i sunčani zimski dani. Stene su krečnjačke i odlikuju se dobrim kvalitetom. Konfiguracije stena su različite, od ploča do jakih previsa i plafona.\n" +
                "Trenutno u Sićevu postoji 14 sportskih smerova težine od 6b do 7c+ (Fr.). Blokovi: NRCC 2010.\n" +
                "ZANIMLJIVOSTI:\n" +
                "Jedna od najboljih sportskih penjačica u svetu, Staša Gejo, rođena je 1997. godine u Nišu. Član je niškog kluba PAEK “Niš” i reprezentativka Srbije. Prvakinja je na brojnim svetskim i evropskim takmičenjima u različitim disciplinama i kategorijama.");
        adventure.setNameEn("Free climbing");
        adventure.setDescriptionEn("Natural rocks:\n" +
                "Jelasnica gorge is the first climbing ground in Serbia designated for sports climbers. From the first directions established in 1994/95., until today, all have been climbed and equipped for sports climbing. Because of its microclimate and the orientation of rocks, the best seasons for climbing are spring and autumn. There are over 200 directions, grading from 4b to 8b (Fr.) and over 250 baulder problems from 3 A to 7C (Fr.). Number of directions: 208 (4b-8b Fr.); Number of baulders: 244 (3A-7C Fr.); Grades: from 5a to 8b+\n" +
                "Sicevo gorge was designated only for the lovers of traditionl climbing. After ’’ Naissus route climbing challenge ’04’’, when 20 directions were equipped , sports climbers have start visiting Sicevo. The rock is oriented towards South, so the ideal seasons for climbing are: spring, autumn, and summer winter days. The rocks of good quality are formed of limestone. The configuration of the rocks is different, from slabs to strong overhangs and ceilings. At the moment, there are 14 directions ranging from 6b to 7c+ (Fr.); Blocks: NRCC 2010.\n" +
                "Interesting facts:\n" +
                "One of the best sport climbers in the world, Stasa Gejo, was born in 1997. in Nis. She is the member of PAEK Nis, the representative of Serbia,and the champion in many European and world competitions in different disciplines and categories.");
        adventure.setImage("climbing");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);

        adventure = new Adventure();
        adventure.setNameSr("Rafting");
        adventure.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Rafting programi na reci Nišavi namenjeni su svim ljubiteljima reke i boravka u prirodi. Organizator obezbeđuje čamce, vesla, kacige i prsluke, a učesnici su dužni da se pridržavaju uputstava organizatora. Ovaj program spada u lake (softplus) programe.\n" +
                "\n" +
                "Rafting u Sićevačkoj klisuri počinje od sela Dolac i vodi do sela Ostrovica, u najlepšem delu Sićevačke klisure. Dužina staze je 7 km, a spust traje oko 3 sata, što zavisi od visine vodostaja, brzine reke kao i intenziteta veslanja.\n" +
                "Nišavski spust počinje od mosta koji se nalazi između Niške Banje i sela Prosek i vodi do Vrežinskog bazena u Nišu. Dužina staze je 8,5 km, a program traje od 2 do 3 sata, što zavisi od visine vodostaja, brzine reke kao i intenziteta veslanja. Regata prolazi pored naselja Ženeva, naselja Brzi Brod i arheološkog nalazišta Medijana.");
        adventure.setNameEn("Rafting");
        adventure.setDescriptionEn("BASIC INFO:\n" +
                "Programs in Nis are recreational, and they are intended for the lovers of river and nature. The organizer provides: boats, oars, helmets and vests, and the participants must follow the instructions of the organizer.\n" +
                "\n" +
                "Rafting in Sicevo gorge. In the most beautiful part of Sicevo gorge it’s mapped out a rafting trail. The program is conveyed on the river between Dolac and Ostrovica. The length of the trail is 7 km, and the descent lasts approximately 3 h, depending on the height of the water level and the intensity of rowing.\n" +
                "Nisava descent occurs on the route from the bridge between Niska Banja and village Prosek to Vrezina pools. The length of the track is 8.5 km, and the program lasts from 2-3 h, depending on the water level, river speed, and the intensity of rowing.");
        adventure.setImage("rafting");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);
/*
        adventure = new Adventure();
        adventure.setNameSr("Jahanje");
        adventure.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Ljubiteljima jahanja konjički klub „Nonius” nudi rekreativno jahanje u Nišu i okolini. U ponudi su jahanje i obilazak Memorijalnog parka Bubanj, jahanje duž Južne Morave, obroncima Seličevice, na Velikom i Malom Jastrepcu, kao i mogućnost višednevnog jahanja i kampovanja. Programi se izvode tokom cele godine, u zavisnosti od vremenskih uslova, osim kampovanja koje se izvodi od maja do novembra.");
        adventure.setNameEn("Horse Riding");
        adventure.setDescriptionEn("BASIC INFO:\n" +
                "Riding club ’’Nonius’’ offers a recreational horse riding in Nis and the surroundings. The riding route includes: riding to the Memorial park Bubanj, riding along the river Juzna Morava and the slopes of Selicevica , on Veliki and Mali Jastrebac , and the program of riding and camping ( a few days program).\n" +
                "Programs are organized throughout the whole year depending on the weather conditions, except for the camping which is organized from May to November .");
        adventure.setImage("jahanje");
        adventure.setLatitude(43.325995);
        adventure.setLongitude(21.895388);
        adventureList.add(adventure);*/


        return adventureList;
    }



}
