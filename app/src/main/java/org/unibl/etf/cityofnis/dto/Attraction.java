package org.unibl.etf.cityofnis.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "attraction")
public class Attraction {


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


    public static ArrayList<Attraction> insertAttractionData(){
        ArrayList<Attraction> attractionList = new ArrayList<>();

        Attraction attraction = new Attraction();
        attraction.setNameSr("Tvrđava");
        attraction.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Stare, čvrste, visoke zidine i kapije niške Tvrđave, koje se od prve polovine 18. veka uzdižu na desnoj obali Nišave, ubrajaju se među najlepše i najbolje očuvane na srednjem Balkanu. Istorija utvrđenja na ovome mestu počinje u 1. v.n.e. kada su rimske legije utirale put novoj svetskoj civilizaciji. Građena od strane Rimljana, Vizantinaca i Srba, tvrđava je rušena i obnavljana više puta, da bi joj konačan izgled dale Osmanlije 1730. godine. Niš je jedan od retkih gradova u svetu sa impozantnom tvrđavom u najužem centru čije se težište nije pomeralo tokom dva milenijuma. Osim dobro očuvanih masivnih kamenih zidina i kapija, u Tvrđavi se mogu videti brojni ostaci burne niške istorije." +
                "\n\nŠETNJA KROZ TVRĐAVU:\n"+
                "\nSTAMBOL KAPIJA (1723.) predstavlja simbol Tvrđave i grada Niša. Sagrađena je u između 1719. i 1723. godine po projektu graditelja Tvrđave Mehmed-age i Mustafa-age iz Sofije. Mermerna ploča, koja se nalazi iznad masivne drvene kapije, postavljena je 1723.godine i obeležava završetak glavnih radova na tvrđavi. Pored bogate orijentalne ornamentike, u gornjem delu kapije nalaze se zupčaste puškarnice i kružni otvori za topove koi su korićeni u odbrani tvrđave i grada. U zasvođenom prolazu nalazile su se prostorije za stražare i zatvorske ćelije.\n" +
                "\nHAMAM (tursko kupatilo, 1498.) Hamam se nalazi na samom ulazu u Tvrđavu, sa leve strane. Prema osmanlijskim popisnim knjigama, postoji od 1498. godine i predstavlja najstariji sačuvan objekat u Tvrđavi iz perioda vladavine Osmanlijskog carstva. Izgrađeno je kao jednostruko kupatilo, koje su mogle koristiti ili samo žene (obično danju) ili samo muškarci (noću). Voda je do hamama dopremena glinenim cevima iz reke, gde je filtrirana i grejana pre upotrebe.\n" +
                "\nARSENAL (1857.) Smešten desno od ulaza u Tvrđavu, arsenal je nekad predstavljao skladište u kojem su čuvani topovi, barut, kugle za topove i drugo oružje i municija. Posebno je konstruisan i zidan u svrhu čuvanja ovako osetljivog materijala. Izgradio ga je Ismail-paša 1857. godine. Arsenal je danas izložbeni prostor Galerije savremene likovne umetnosti.\n" +
                "\nANTIČKE TERME (4.vek ). Smeštene na samom ulazu nekadašnjeg Naisusa, terme su bile deo procedure da se svako ko želi ući u grad mora pre toga okupati. Ovaj objekat datira iz IV veka i do danas su ostale očuvane gotovo sve prostorije koje su činile kompleks antičkog kupatila: dve centralne prostorije koje su predstavljale svlačionicu, hladno (frigidarium) i toplo kupatilo (tepidarium).\n" +
                "\nSPOMENIK MILANU OBRENOVIĆU (1902.) Spomenik knezu, a kasnije i kralju Milanu Obrenoviću podignut je 1902. godine, u znak zahvalnosti njemu i vojsci koja je oslobodila Niš od petovekovnog jarma osmanlijske imperije. Spomenik je simbolično otkriven na dvadesetpetogodišnjicu od oslobođenja i prvu godišnjicu smrti kralja Milana Obrenovića. Italijanski kamenorezac Vinćenco Kaliterna izradio je jedinstven spomenik u obliku puščanog metka, koji sa okolnom kompozicijom ističe simboliku oslobodilačkog rata.\n" +
                "\nBali -begova džamija – Džamija je zadužbina janjičarskog zapovednika Balije iz Jedrena i jedina je sačuvana džamija uTvrđavi. Sa svojim lukovima i svodovima, kao i raskošno ukrašenim prozorima, predstavlja pravi biser orijentalne arhitekture. Prvi put se spominje 1521. godine kao manja verska bogomolja, tek se u popisima iz 1710. godine vodi kao džamija. Danas se ovaj interesantan deo prošlosti Niša zove „Salon 77“ i predstavlja izložbeni prostor Galerije savremene likovne umetnosti.\n" +
                "\nLAPIDARIJUM (1-4. vek). Lapidarijum je jedinstvena zbirka nadgrobnih spomenika koja spada u najstarije antičke spomenike u Srbiji. Prvi put je pominje austrijski putopisac Feliks Kanic 1887.godine, tako da se može smatrati prvom postavkom muzejskih eksponata u Nišu. Nalazi se na centralnom platou Tvrđave i sastoji se od 41 spomenika iz perioda od I do IV veka. Postavku čine nadgrobni i zavetni spomenici, žrtvenici, sarkofazi i skulpture koje su uglavnom pronađene u Tvrđavi, ali i u okolini Niša i Knjaževca.\n" +
                "\nANTIČKA ULICA SA BAZILIKOM (2 – 4. vek ) Antički Naisus je u jednom periodu svog razvoja (III vek) postao „municipijum“. Takav status nije mogao imati svaki grad, već samo gradovi od većeg značaja za rimsku imperiju na određenoj teritoriji. Zbog toga je bio raskošno izgrađen i ukrašen. Deo kasnoantičke arhitekture nalazimo i u sačuvanom delu ulice sa bazilikom (II-IV vek), koja je uz „objekat sa svodovima“ činila središnji, najraskošniji deo Naisusa.\n" +
                "\nBARUTANE (1723.) Barutane potiču iz perioda nastanka same tvrđave (1723.). „Džebane“, kako su ih nazivale Osmanlije, bile su namenjene za skladištenje baruta i municije na udaljenim delovima tvrđave. Ukupno iz je bilo pet, a danas se mogu videti četiri, koje se nalaze uz severni i istočni deo bedema. To su pravougaone prizemne građevine sa masivnim, dvostrukim zidovima. Na spoljašnjim zidovima nalaze se otvori kroz koji su vojnici mogli pucati i braniti tvrđavu.\n" +
                "\nSPOMEN KOSTURNICA (1927) Tokom Prvog svetskog rata, bugarska vojska bila je smeštena u Tvrđavi ikoristila delove podzemnih hodnikakao tamnice i mučilišta. Najveći broj Nišlija i srpskih ustanika stradao je ovde 1917. godine nakon neuspelog Topličkog ustanka. Na mestu streljanja srpskih rodoljuba, u rovovima Tvrđave, podignuta je spomen kosturnica, a severna kapija, kroz koju su zarobljenici dovođeni na streljanje, od tada nosi naziv „Kapija smrti“.\n" +
                "\nPALATA SA OKTAGONOM (4. vek) Palata je svakako najluksuzniji objekat nasleđen iz IV veka. Prema načinu gradnje, ukrasima i predmetima pronađenim u njoj, smatra se da je pripadala veoma uticajnoj ličnosti antičkog Naisusa, možda i samom caru Konstantinu. Istraženi deo o raskoši nekadašnje palate govori činjenica da je bila opremljena podnim i zidnim grejanjem, da su svi zidovi prostorija bili ukrašeni freskama, a centralna prostorija u obliku oktogona imala je bogato dekorisane podne mozaike.\n"+
                "\nISTORIJA TVRĐAVE:\n" +
                        "Antička Tvrđava – Rimski grad Naissus\n" +
                        "\n" +
                        "Istorija niške Tvrđave počinje pre više od 2000 godina, u I veku nove ere, kada rimske legije prodiru iz pravca juga i na obali reke formiraju vojni logor. Uz vojni logor koji se nalazio u centralnom delu današnje Tvrđave počinje da se razvija naselje koje ubrzo prerasta u „rimski municipijum“ – Naisus, o čemu svedoče zapisi grčkog geografa Klaudija Ptolomeja iz II veka.\n" +
                        "\n" +
                        "U Naissusu je 27. februara 274. godine rođen jedan od najvećih državnika u istoriji Evrope, Konstantin Veliki. U periodu kada počinje priča o Konstantinu Velikom, antički Naisus (današnji Niš) bio je centralno mesto rimske pokrajine Gornja Mezija. Nevelik po broju stanovnika (20000), ali značajan kao trgovački, vojni i administrativni centar, Naisus se brzo razvijao i širio van zidina Tvrđave.\n" +
                        "\n" +
                        "Centralno gradsko jezgro, koje se nalazilo na području današnje Tvrđave, bilo je izgrađeno prema pravilima rimskog urbanizma. Centralni deo činio je raskošni trg (forum) ukrašen statuama rimskih božanstava, oko kojeg su se nalazile upravne zgrade, vojni objekti, radionice i bazilika.\n" +
                        "\n" +
                        "Ostaci pojedinih objekata iz tog perioda mogu se i danas videti u niškoj Tvrđavi (lapidarijum,antičke terme, objekat sa svodovima, antička ulica i palata sa oktogonom).\n" +
                        "\n" +
                        "Osmanlijska Tvrđava\n" +
                        "\n" +
                        "Kada je knez Lazar saznao da je Niš osvojen, rekao je: „Od njega tvrđeg grada nisam imao. Kad je on osvojen, šta vrede ostali?“\n" +
                        "\n" +
                        "U drugoj polovini XIV veka srpski knez Lazar Hrebeljanović ojačao je bedeme Tvrđave, pripremajući se za odbranu od nadirućeg talasa osmanlijske vojske.\n" +
                        "\n" +
                        "Kao jedno od najvažnijih strateških mesta na Balkanu, Niš se našao na njihovom udaru već 1386. godine. Nakon dvadeset pet dana neprestanih napada – grad i Tvrđava su osvojeni. Opisujući srčanu borbu za odbranu grada, osmanlijski hroničar, između ostalog, kaže za Niš: „Ovaj grad je tvrdo uporište koje liči na nakostrešenog zmaja sa jedovitim bodljama“.\n" +
                        "\n" +
                        "Naredna četiri veka pod osmanlijskom imperijom Tvrđava nije menjala svoj izgled. Nakon poraza od Austrougarske, početkom XVIII veka, osmanlijska vojska napušta Beograd, a Niš postaje centar njihove teritorije na tlu Evrope. Kako bi osigurao postojeće granice, 19. februara 1719, sultan Ahmed III potpisuje povelju o početku izgradnje velike i snažne tvrđave na Nišavi.\n" +
                        "\n" +
                        "Tvrđava koja se danas nalazi u centru Niša građena je u periodu od 1719. do 1730. godine. Za njenu obnovu angažovano je preko deset hiljada spahija iz četrnaest sandžaka, četrdeset carigradskih kamenorezaca, a na izgradnji bedema radilo je preko četiristo zidara. Završetak glavnih radova obeležen je postavljanjem table na Stambol kapiji 1723. godine."
        );
        attraction.setNameEn("The Fortress");
        attraction.setDescriptionEn("BASIC INFO:\n" +
                "Old, strong, high ramparts and grates of Niš Fortress, which has stood on the right bank of the Nišava since the first half of the 18th century, are counted as one of the most beautiful and best preserved fortresses in the Central Balkans. The history of the fortification in this location began in the 1st century AD when Roman legions paved the way for a new civilization.\n" +
                "Built both by Romans and Serbs, the fortress was razed and rebuilt several times until the Ottomans gave its final appearance in 1730. Niš is one of the rare cities in the world with an impressive fortress in the very center that hasn’t been moved for two millennia.\n" +
                "\n" +
                "Apart from the well preserved stone walls and gates, the Fortress exhibits numerous remains from the turbulent history of Nis. It is also a park, a green oasis in the centre of the city , with a lot of caffes and children playgrounds.\n"+
        "\n\nMAJOR ATTRACTIONS INSIDE THE FORTRESS:\n" +
                        "\nSTAMBOL GATE (1723.) represents a symbol of the Fortress and the city of Nis. It was built in the period between 1719. and 1723. The marble slab, which is located above the massive wooden gate, was set in 1723. and represents the completion of the main works on the fortress. Besides the rich oriental ornaments on the topside of the gate, there are gear-shaped loopholes and circular holes for cannons which were used for defence of the fortress and the city. There were guard-houses and prison cells in the vaulted passage.\n" +
                        "\nHAMAM (Turkish Bath, 1498.) is located at the very entrance of the Fortress, at the left side. According to Ottoman census books, the hammam has existed since 1498 and it represents the best preserved building in the Fortress from the period of the Ottoman rule. It was built as a single bath that was used either by women (usually by day) or by men (by night). Clay pipes used to bring water from the river to the hammam, where it was filtered and heated before it was used.\n" +
                        "\nTHE ARSENAL (1857.) Located on the right of the entrance of the Fortress, the Arsenal used to be a storehouse where cannons, gunpowder, cannonballs and other weapon and ammunitions were kept. It was specially designed and built with the purpose of storing sensitive materials. It was built by Ismail Pasha in 1857. The Arsenal serves today as an exhibition area of the Gallery of Contemporary Fine Arts.\n" +
                        "\nROMAN THERMAE (4th century). Located at the very entrance of former Naissus, thermae used to play a role in a procedure demanding everyone to bathe before entering the city. This building dates from the 4th century and almost all rooms that comprised the complex of the ancient bath are still preserved today: two central changing rooms, a cold (frigidarium) and a warm (tepidarium) bath.\n" +
                        "\nPRINCE MILAN OBRENOVIC AND NIS LIBERATORS MONUMENT (1902.) was erected in gratitude to prince and his army for liberating Niš from the five century long rule of the Ottoman Empire. The monument was symbolically unveiled at the twenty-fifth anniversary of the liberation and the first anniversary since the death of King Milan Obrenović. Italian stonecutter Vincenzo Caliterna made the original monument in the form of a gun bullet, which, with the surrounding composition, represents symbols of the liberation.\n" +
                        "\nBALI-BEY MOSQUE (1521.) A mosque is built by a janissary commander Balia from Edrine and it is the only preserved mosque within the Fortress. With its arches and vaults, as well as with richly decorated windows, it represents a pearl of oriental architecture. It was first mentioned in 1521 as a smaller worship place, and not before 1710 was it mentioned as a mosque. Today, this interesting piece of history of Niš is called “Salon 77” and it is an exhibition space of the Gallery of Contemporary Fine Arts.\n" +
                        "\nLAPIDARIUM (1st – 4th century). A lapidarium is a unique collection of tombstones which are among the oldest antique monuments in Serbia. It was mentioned first by Austrian traveler Felix Kanitz in 1887, and it can be regarded as the first exhibition in Niš. It is located at the central plateau inside the Fortress and consists of 41 stones from the period between the 1st and the 4th century. The exhibition is comprised of tombstones, votive and sacrificial stones, sarcophagi and sculptures found primarily in the Fortress, but also in the vicinity of Niš and Knjaževac.\n" +
                        "\nANTIQUE STREET WITH BASILICA (2nd-4th century) In one period of its development (3rd century), ancient Naissus became a “municipium”. Not just any city could have such a status, only cities of greater importance for the Roman Empire in a certain area. Because of that, it was lavishly built and decorated. Examples of Late Antiquity architecture can be found in a preserved part of a street with a basilica (2nd-4th century) which made the central, the most sumptuous part of Naissus along with “the Building with Vaults”.\n" +
                        "\nGUNPOWDER MAGAZINES (1723.) are military facilities used for the storage of gunpowder and ammunition. Five remain preserved, 4 located along the northern rampart, while another small one is situated in the eastern part of the Fortress.\n" +

                        "\nPALACE WITH AN OCTAGON (4th century) The Palace is certainly the most lavish building from the 4th century. Because of the construction style, decorations and objects found in it, it is believed that it belonged to some influential person of ancient Naissus, maybe even to Emperor Constantine himself. The examined part is 11 x 30 meters large, but the entire building was much larger.\n\n"+

                "THE HISTORY OF THE FORTRESS:\n" +
                        "Antique Fortress – Roman city Naissus" +
                        "\n" +
                        "The history of the fortification in this location began in the 1st century AD when Roman legions paved the way for a new civilization. In 2nd century AD, Greek geographer from Alexandria, Ptolemy documented the city of Niš under the name of Naisus.\n" +
                        "\n" +
                        "On February 27th. 274, one of the greatest statesmen in European history, Constantine the Great was born in Naissus . At the time when the story of Constantine the Great begins, ancient Naissus was a central place of the Roman province of Upper Moesia. Small according to the number of inhabitants (20.000) but important as a commercial, military and administrative center, Naisus developed fast.\n" +
                        "\n" +
                        "The city center, which was located in the area of the present-day Fortress, was built in accordance with the principles of Roman urbanism. A central part was a sumptuous square (forum), decorated with statues of Roman gods and surrounded with administration and military buildings, workshops and a basilica.\n" +
                        "\n" +
                        "The remains of some buildings from this period can be still seen today in Niš Fortress ( Lapidarium, Termae, Building with Arches, Ancient street and a Palace with an Octagon).\n" +
                        "\n" +
                        "Ottoman Fotress \n" +
                        "In the second half of 14th century, Serbian Prince Lazar Hrebeljanović improved the ramparts of the fortress while preparing for the defense against a rising wave of the Ottoman army.\n" +
                        "As one of the most important strategic points in the Balkans, Niš was found under their attack as early as in 1386. After twenty-five days of continuous attack – the city and the Fortress were conquered. Describing a fierce fight in defense of the city, an Ottoman chronicler, besides other things, says about Niš: “This city is a toughstronghold that resembles a bristling dragon with angry spines”.\n" +
                        "In the following four centuries under the Ottoman Empire, the Fortress didn’t change its appearance. After the defeat by the Austro-Hungarians at the beginning of the 18thcentury, the Ottoman army left Belgrade, and Niš became the center of their territory on European soil. In order to preserve the existing borders, Sultan Ahmed III issued a decree on February 19th, 1719 that the construction of a large and strong fortress on the Nišava would begin.\n" +
                        "The present-day Fortress in the downtown of Nis was built in the period between 1719. and 1730. For its reconstruction it was hired more than 10 000 landowners from 14 provinces, 40 stonecutters from Istanbul, while on the construction of walls worked more than 400 bricklayers. The stone was brought from the quarries in the surroundings of Nis. The end of the main construction works was marked by putting a panel on Stambol gate in 1723."

        );
        attraction.setImage("niska_tvrdjava");
        attraction.setLatitude(43.325995);
        attraction.setLongitude(21.895388);

        attractionList.add(attraction);






        attraction = new Attraction();
        attraction.setNameSr("Kazandžijsko sokače");
        attraction.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Kazandžijsko sokače je poslednja sačuvana ulica nekadašnje niške čaršije. Početkom XIX veka bila je zanatlijski sokak i sve do poslednjih godina XX veka zadržane su stare zanatske radnje i nekoliko kuća iz osmanlijskog perioda. Ovi objekti su vremenom renovirani i uređeni kao restorani, kafići, kafane i hoteli koji su zadržali duh stare arhitekture.");
        attraction.setNameEn("Tinkers Alley");
        attraction.setDescriptionEn("BASIC INFO:\nTinkers Alley (Kazandžijsko sokače) is the last preserved street of the former Niš bazaar from the beginning of the 19th century. Originaly it was a craftsmen alley and over the time the buildings have been renovated and redesigned as restaurants, bars, taverns and hotels, still preserving the spirit of the old architecture");
        attraction.setImage("kazandzijsko_sokace");
        attraction.setLatitude(43.317864);
        attraction.setLongitude(21.895731);

        attractionList.add(attraction);



         attraction = new Attraction();
        attraction.setNameSr("Spomenik na Čegru");
        attraction.setDescriptionSr("Na mestu na kome se nalazio šanac Stevana Sinđelića i njegovih vojnika podignut je spomenik u obliku kule –simbol vojnog utvrđenja (1927). Projektant spomenika je Đulijan Đupon, ruski emigrant iz Niša, dok je bronzano poprsje Stevana Sinđelića, koje se nalazi u kuli, izradio jugoslovenski vajar Slavko Miletić. Ovaj spomenik simbolizuje herojski podvig vojvode Sinđelića i čuva uspomenu na borbu za slobodu.");
        attraction.setNameEn("Cegar Monument");
        attraction.setDescriptionEn("At the place where the trench of Stevan Sindjelic and his soldiers was located, a monument was erected in the shape of a tower – a symbol of the military fortification (1927). The designer of the monument was Djulijan Djupon, a Russian immigrant from Nis, and a bronze bust of Stevan Sindjelic, which is placed in the tower, was made by Yugoslavian sculptor Slavko Miletic. Today, this monument symbolizes the heroism of Stevan Sinđelić and evokes the memory of the fearless fight for freedom.");
        attraction.setImage("spomenik_cegar");
        attraction.setLatitude(43.365531);
        attraction.setLongitude(21.942744);

        attractionList.add(attraction);


        attraction = new Attraction();
        attraction.setNameSr("Kuća Stambolijski");
        attraction.setDescriptionSr("OPŠTE INFORMACIJE:\n" +
                "Kuća Stambolijskih se nalazi u ulici Nikole Pašića i predstavlja nasleđe orijentalne arhitekture iz perioda vladavine Osmanlijskog carstva ovim prostorima. Sagrađena je 1875. godine kao bogata varoška stambena kuća sa više od deset prostorija i pripada profanoj balkanskoj arhitekturi" +
                "\n\nVIŠE INFORMACIJA:\n" +
                "U sačuvanim zapisima stoji da je gradnju započeo Osmanlija, Ahmet Memetović 1875. godine, koji je nedovršenu kuću prodao poznatom niškom trgovcu Todoru Stankoviću – Stamboliji za 25 zlatnih lira. Nadimak novog vlasnika, koji je dobio zbog svojih trgovačkih veza s Istanbulom, dodelio je i kući naziv „Kuća Stambolijskih“. Danas se u ovog zgradi nalazi ekskluzivni etno restoran pod nazivom „Stambolijski“.");
        attraction.setNameEn("Stambolija House");
        attraction.setDescriptionEn("BASIC INFO:\n" +
                "Due to its turbulent history and geographic location, Niš has become a real treasury of architectural styles, presenting a mix of influences. Stambolija House represents yet another monument from the period of Ottoman rule over this area." +
                "\n\nMORE INFO:\n" +
                "From the preserved records, we learn that the construction was begun by a Turk, AhmetMemetović in 1875, who sold the unfinished house to a well-known merchant from Niš, TodorStanković – Stambolija for 25 golden liras. The nickname of the new owner, who got it because of his commercial relations with Istanbul, gave the name to the house – “Stambolija House“. This building belongs to the profane Balkan architecture style and it was built as a lavish city residence house with more than 10 rooms.\n" +
                "\n" +
                "Today, Stambolija house is an ethnorestaurant called“Stamboljiski”.");
        attraction.setImage("kuca_stambolijski");
        attraction.setLatitude(43.318691);
        attraction.setLongitude(21.893223);

        attractionList.add(attraction);






        return attractionList;
    }

}
