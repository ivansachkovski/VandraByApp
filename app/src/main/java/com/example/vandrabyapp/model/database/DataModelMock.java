package com.example.vandrabyapp.model.database;

import com.example.vandrabyapp.model.entities.Place;
import com.example.vandrabyapp.model.entities.Route;
import com.example.vandrabyapp.model.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataModelMock extends DataModel {

    private User user;
    private List<Place> places;
    private List<Route> routes;

    @Override
    public void init() {
        initUser();
        initPlaces();
        initRoutes();
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public List<Place> getUnratedPlaces() {
        List<Place> result = new ArrayList<>();

        for (Place place : places) {
            long placeId = place.getId();
            if (!user.isPlaceLiked(placeId) && !user.isPlaceDisliked(placeId) && !user.isPlaceVisited(placeId)) {
                result.add(place);
            }
        }

        return result;
    }

    @Override
    public List<Place> getUserLikedPlaces() {
        List<Place> result = new ArrayList<>();

        for (Place place : places) {
            long placeId = place.getId();
            if (user.isPlaceLiked(placeId)) {
                result.add(place);
            }
        }

        return result;
    }

    @Override
    public List<Place> getUserVisitedPlaces() {
        return places;
    }

    @Override
    public void markPlaceAsLiked(long placeId) {
        user.addLikedPlace(placeId);
    }

    @Override
    public void markPlaceAsDisliked(long placeId) {
        user.addDislikedPlace(placeId);
    }

    @Override
    public void markPlaceAsVisited(long placeId) {
        user.addVisitedPlace(placeId);
    }

    @Override
    public void addRoute(Route route) {
        routes.add(route);
    }

    @Override
    public List<Route> getRoutes() {
        return routes;
    }

    private void initUser() {
        user = new User();
        user.setName("Временный пользователь");
        user.setNickname("ABOBA");
    }

    private void initPlaces() {
        places = new ArrayList<>();
        places.add(new Place(1, "Костел Святого Антония", "По архивным данным в 1924 году костёл святого Антония отмечался как действующий. По рассказам местных жителей этой деревушки службы велись до 1929 году. Однако вскоре его закрыли, с храма были демонтировали кресты.", "Костёл", 1714, Arrays.asList("https://upload.wikimedia.org/wikipedia/commons/f/f2/Lepiel%2C_ka%C5%9Bcio%C5%82_%2813.08.2008%29.jpg", "https://www.radzima.org/images/pamatniki/4908/vilelepe02-11.jpg", "https://www.holiday.by/files/sights/thumbnails/sights_gallery_fullsize/4d1bf4f00e54c563214365692c60486e-orig.jpg"), "Витебская", "Лепельский", "деревня", "Губино"));
        places.add(new Place(2, "Мирский замок", "Ми́рский за́мок (белор. Мірскі замак), за́мково-па́рковый ко́мплекс «Мир» (белор. замкава-палацавы комплекс «Мір») — оборонительное укрепление и резиденция в городском посёлке (пгт) Мир Кореличского района Гродненской области Белоруссии. Памятник архитектуры, внесён в список Всемирного наследия ЮНЕСКО (с 2000 года). Архитектурный комплекс включает в себя замок XVI—XX веков, валы XVII—XVIII веков, пруд 1896—1898 годов, часовню-усыпальницу Святополк-Мирских с домом сторожа и воротами, пейзажный и регулярный парки, дом управляющего. Находится в пгт Мир, на правом берегу реки Миранки[1].\r\n\r\nПостроенный в начале XVI века магнатом Ю. И. Ильиничем замок стал первым частнособственническим замком на землях Белоруссии[2][3]. С 1568 г. замком владели Радзивиллы (до 1828), потом Витгенштейны (до 1891). Последними владельцами замка были князья Святополк-Мирские (до 1939), после чего с приходом советской власти замок стал государственной собственностью. Мирский замок является самым восточным готическим сооружением, а также самым крупным и единственным не культовым объектом из сохранившихся немногих образцов самобытной белорусской готики[4].\r\n\r\nЗамок по строению похож на квадрат со стороной около 75 метров, по углам расположены пятиэтажные башни высотой 25—27 м, которые выходят за пределы стен. Пятая башня — шестиэтажная с въездными воротами[5].\r\n\r\nКомплекс участвовал практически во всех войнах, которые проносились в своё время на белорусской земле: начиная с русско-польской войны 1654—1667 гг. и до Отечественной войны 1812 года[6], замок не раз брали в осаду и штурмовали его. Был повреждён в 1665 и 1706 годах, после восстановлен в начале XVIII века. Потом снова был сильно повреждён в 1794 году. В 1812 под стенами замка состоялся бой между польской кавалерией генерала Рожнецкого, входившей в состав французской армии, и арьергардом 2-й русской армии — казачьей конницей М. И. Платова[7].\r\n\r\nМирский замок для своего времени был мощным военным сооружением, где были применёны почти все известные элементы Средневековой фортификации и были воплощёны местные традиции замкового зодчества. Строили его по проекту талантливого архитектора, который, скорее всего, был мастером из народа и владел художественным вкусом. Отсутствие хороших приспособлений не помешало зодчему создать первоклассное для того времени военно-инженерное сооружение и украсить его разнообразными архитектурными деталями[8]. Большая насыщенность огневых средств при взаимном перекрывании секторов обстрела, постановка башен с расчётом ведения флангового огня вдоль стен, высокие, крутые валы с бастионами по углам делали Мирский замок первоклассным оборонительным сооружением своего времени[9].", "Замок", 1520, Arrays.asList("https://s5-goods.ozstatic.by/2000/169/841/10/10841169_0.jpg", "https://bestbelarus.by/upload/iblock/8e6/8e662d4eddc5d5b7653b7b9fceb23626.jpg"), "Гродненская", "Кореличский", "посёлок", "Мир"));
        places.add(new Place(3, "Церковь Святой Параскевы Пятницы", "Деревянная церковь Святой Параскевы Пятницы была построена в 1841–1844 годах. Возводилась она на месте старого храма, основанного еще канцлером ВКЛ Львом Сапегой в 1586 году.\r\n\r\nВ начале ХХ века церковь была перестроена. Сейчас в ней находятся две старинные иконы: Матери Божьей Смоленской XVIII века и Апостолов Петра и Павла первой половины XIX века, что привлекает в Лепель паломников.", "Церковь", 1844, Arrays.asList("https://radzima.org/images/pamatniki/4907/vilelepe01-01.jpg", "https://vetliva.ru/upload/resize_cache/iblock/a76/1170_640_2ad00f77cb8d50abfaeeae09efd4a5122/a76a674084c2f865f0364534bf530726.jpg"), "Витебская", "Лепельский", "город", "Лепель"));
        places.add(new Place(4, "Красный костёл", "Костёл святого Симеона и святой Елены (белор. Касцёл святога Сымона і святой Алены, польск. Kościół św. Szymona i Heleny), часто называемый также Красным костёлом — наиболее известный католический храм Минска.\r\n\r\nАдминистративно относится к юго-восточному деканату Минско-Могилёвской архиепархии. Памятник архитектуры, включён в Государственный список историко-культурных ценностей Республики Беларусь (код 713Г000229)[1]. В ряде источников, включая воспоминания самого фундатора храма Эдварда Войниловича, стиль храма характеризуется как неороманский[2], в ряде других, как неоготика с чертами модерна[1][3].\r\n\r\nКостёл находится на площади Независимости в непосредственной близости от Дома Правительства.", "Костёл", 1910, Arrays.asList("https://upload.wikimedia.org/wikipedia/commons/3/39/%D0%9A%D0%BE%D1%81%D1%82%D0%B5%D0%BB_%D0%A1%D0%B8%D0%BC%D0%BE%D0%BD%D0%B0_%D0%B8_%D0%90%D0%BB%D0%B5%D0%BD%D1%8B_3.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Belarus-Minsk-Church_of_Simon_and_Helena-7-2.jpg/220px-Belarus-Minsk-Church_of_Simon_and_Helena-7-2.jpg"), "Минская", "Минский", "город", "Минск"));
    }

    private void initRoutes() {
        routes = new ArrayList<>();
    }
}