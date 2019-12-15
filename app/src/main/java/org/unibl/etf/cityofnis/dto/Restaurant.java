package org.unibl.etf.cityofnis.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "restaurant")
public class Restaurant {


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

    public static ArrayList<Restaurant> insertRestaurantData(){
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        Restaurant restaurant = new Restaurant();
        restaurant.setNameSr("Kafana Galija");
        restaurant.setDescriptionSr("Nekada ranije kafana Galija je važila za gradsku kafanu u Nišu. Sve značajne ličnosti u gradu su imale svoj sto u ovoj kafani a često čekalo i po nekoliko sati kako bi se neki sto oslobodio.\n" +
                "\n" +
                "Galija se nalazi u centru Niša i idealno je mesto da uz odličnu hranu uživate u autentično uređenom ambijentu ili u bašti koja izlazi na Kazandžijsko sokače, najveću ambijentalnu atrakciju u Nišu.\n" +
                "\n" +
                "Pored toga što ćete biti u kafani u kojoj je nastala istoimena rok grupa definitvno ćete uživati u odličnoj hrani. U ponudi su jela tradicionalne srpske kuhinje i za šta god da se odlučite nećete pogrešiti. Vikendom su večeri naročito zanimljive uz tamburaše. Ipak, rezervacija će vam biti neophodna.");
        restaurant.setNameEn("Cafe Galia");
        restaurant.setDescriptionEn("Once before the cafe Galia was valid for the city cafe in Nis. All the important figures in the city had their own table in this cafe, and often waited several hours to get some free.\n" +
                "\n" +
                "Galija is located in the center of Nis and it is an ideal place to enjoy good food in an authentically decorated ambience or in the garden that comes out on the 'Kazandžijsko sokače', the largest ambience attraction in Niš.\n" +
                "\n" +
                "In addition to being in the cafe where the roots of the same name have been created, you will definitely enjoy great food. They offer traditional Serbian cuisine and whatever you decide you will not make mistakes. On weekends, evenings are particularly interesting with tambourines. However, the reservation will be necessary.");
        restaurant.setImage("galija");
        restaurant.setLatitude(43.3182342);
        restaurant.setLongitude(21.89599);
        restaurantList.add(restaurant);



        restaurant = new Restaurant();
        restaurant.setNameSr("Mali podrum");
        restaurant.setDescriptionSr("Kako i samo ime govori ovaj restoran se nalazi u podrumskoj prostoriji koja je male površine. Unutra nema više od 10 stolova ali ćete biti presrećni ukoliko pronađete neki prazan bez prethodne rezervacije, u bilo koje doba dana, što dovoljno govori o kvalitetu.\n" +
                "\n" +
                "Ovaj restoran se takođe nalazi u širem centru grada, a Nišlije će vam reći da se nalazi \"kod Šojke\".\n" +
                "\n" +
                "U Mali podrum se ne dolazi zbog fensi zalogaja. Ovde se dolazi zbog jagnjećih sarmica i odličnog jagnjećeg pečenja. Ostatak menija takođe odlikuju specijaliteti domaće kuhinje. Izbor vina je veoma dobar.");
        restaurant.setNameEn("Small cellar");
        restaurant.setDescriptionEn("As the name implies, this restaurant is located in a cellar room with a small area. There are no more than 10 tables inside but you will be happy if you find some empty without a previous booking, at any time of the day, which speaks enough about quality.\n" +
                "\n" +
                "This restaurant is also located in the wider city center, and Nišli will tell you that it is located near \"Sojka\".\n" +
                "\n" +
                "The little cellar does not come because of the fancy bite. It comes here because of lambs and excellent lamb roasting. The rest of the menu also features local cuisine specialties. The choice of wine is very good.");
        restaurant.setImage("mali_podrum");
        restaurant.setLatitude(43.3154546);
        restaurant.setLongitude(21.8904743);
        restaurantList.add(restaurant);


        restaurant = new Restaurant();
        restaurant.setNameSr("Kafana \"Kod Brke\"");
        restaurant.setDescriptionSr("Ovo je mesto koje će vam gotovo svako preporučiti, bilo da je Nišlija ili turista koji je nedavno posetio Niš.\n" +
                "\n" +
                "Probelem je što se \"Brka\" ne nalazi u gradu već u selu Jelašnica, na nekih 20 minuta vožnje kolima, što znači da vam je auto neophodan da biste stigli do ove kafane. Možete uzeti i taksi ukoliko to sebi možete priuštiti a možda ćete dobiti i gratis povratak i čekanje ukoliko i taksisti uzmete jednu Brkinu sukanu pitu." +
                "Tako je, sukana pita je definitivno specijalitet kuće kod Brke i ukoliko izađete iz kafane ne probavši je zajedno sa kiselim mlekom načinićete veliko svetogrđe. Sarmice u vinovom listu, punjene paprike, butkica i jagnjetina će vam se zalepiti za srce.\n" +
                "\n" +
                "Nemojte računati na telefon kada ste kod Brke jer ovde nema signala a ni interneta. A i ne treba vam, tu ste da uživate u odličnoj hrani, veoma lepo uređenom ambijentu i razgovoru sa ljudima.");
        restaurant.setNameEn("Tavern \"Kod Brke\"");
        restaurant.setDescriptionEn("This is a place that almost everybody will recommend to you, whether Nislija or a tourist who recently visited Nis.\n" +
                "\n" +
                "\"Brka\" is not located in the town, but in the village of Jelasnica, about 20 minutes by car, which means your car is necessary to reach this tavern. You can also take a taxi if you can afford it and you may also get a free return and a wait if you also take a taxi to Brkina wrapped pie." +
                "That's right, the wrapped pie is definitely a specialty of Brka's house, and if you go out of the tavern without digesting it together with sour milk you will make a lot of sacrilege. Sarmice in a vine list, stuffed peppers, roasted lamb meat will stick to your heart.\n" +
                "\n" +
                "Do not count on the phone when you are at Brka because there is no signal here and no internet. And you do not need, you are here to enjoy great food, a very nice ambience and conversation with people.");
        restaurant.setImage("kafana_kod_brke");
        restaurant.setLatitude(43.2918913);
        restaurant.setLongitude(22.0587015);
        restaurantList.add(restaurant);

        restaurant = new Restaurant();
        restaurant.setNameSr("New City Restaurant");
        restaurant.setDescriptionSr("New City Hotel poseduje izuzetan A la carte restoran. Glavni kuvar je očigledno veoma inspirisan pa ćete na meniju ovog restorana za hladno predjelo pronaći pršutu sa smokvama i kremom od rena i rokfora ili goveđi karpaćo, bruskete ili rolovane špargle za toplo predjelo." +
                "Za glavno jelo možete izabrati neku od brojnih varijacija testenine, rižota, obrok salata, mesa i ribe, a sve zasladite voćnom tortom ili tartom od mente, uz neko od odličnih vina na meniju koje će vam preporučiti somelijer restorana.\n" +
                "\n" +
                "Kada se umorite od jagnjetine i roštilja ovaj restoran u samom centru grada je pravi izbor za ručak ili večeru. Moderan enterijer i čitav ambijent daju svakom zalogaju u ovom restoranu posebnu dozu ekskluzivnosti.");
        restaurant.setNameEn("New City Restaurant");
        restaurant.setDescriptionEn("New City Hotel, which owns an exceptional A la carte restaurant. The main chef is obviously very inspired, and on the menu of this restaurant for cold appetizers you will find smoked figs and rhubarb or rhubarb creams or beef carp, grilled or rolled asparagus for a warm appetizer.\n" +
                "\n" +
                "For the main course you can choose from a number of variations of pasta, risotto, meal of salad, meat and fish, and sweeten all with a fruit cake or mint tart, along with some of the great wines on the menu that will be recommended by the sommelier of the restaurant.\n" +
                "\n" +
                "When you are tired of lamb and barbecue this restaurant in the very center of the city is the right choice for lunch or dinner. The stylish interior and the entire ambience give each restaurant a special dose of exclusivity in this restaurant.");
        restaurant.setImage("new_city_restaurant");
        restaurant.setLatitude(43.320584);
        restaurant.setLongitude(21.897855);
        restaurantList.add(restaurant);


        restaurant = new Restaurant();
        restaurant.setNameSr("Pleasure Club");
        restaurant.setDescriptionSr("Restoran u popularnom Kazandžijskom sokačetu i verovatno najpopularniji restoran u Nišu nekafanskog tipa.\n" +
                "\n" +
                "Ambijent u restoranu je veoma prijatan a osoblje ljubazno i izuzetno profesionalno.\n" +
                "\n" +
                "Ovde nećete pronaći roštilj ali možete poručiti šefovu salatu, prolećne rolnice, izvrsnu testeninu i zasladiti se najboljim cheese cake-om u Nišu. Tu je i piletina u raznim sosevima, pice, brojne i raznovrsne salate i mnogo drugih kolača. Sve je veoma ukusno tako da ne možete napraviti loš izbor.\n" +
                "\n" +
                "Kokteli i kafe su takođe odličnog kvaliteta.");
        restaurant.setNameEn("Pleasure Club");
        restaurant.setDescriptionEn("A restaurant in the popular \"Kazandžijski sokak\" and probably the most popular restaurant in Niš of a non-Copper type.\n" +
                "\n" +
                "The ambience in the restaurant is very pleasant and the staff is friendly and extremely professional.\n" +
                "\n" +
                "You will not find barbecue here, but you can order a bacon salad, spring rolls, excellent pasta and sweeten the best cheese cake in Nis. There is also chicken in various sauces, pizzas, numerous and varied salads and many other cakes. Everything is very tasty so you can not make a bad choice.\n" +
                "\n" +
                "Cocktails and coffee are also of excellent quality.");
        restaurant.setImage("pleasure_caffe");
        restaurant.setLatitude(43.317811);
        restaurant.setLongitude(21.895779);
        restaurantList.add(restaurant);

        return restaurantList;
    }


}
