package com.example2.demo2.service;


import com.example2.demo2.entity.CatsEntity;
import com.example2.demo2.entity.ColorCat;
import com.example2.demo2.entity.FriendshipEntity;
import com.example2.demo2.entity.HumanEntity;
import com.example2.demo2.dao.CatsEntityRepositroy;
import com.example2.demo2.dao.FriendshipEntityRepository;
import com.example2.demo2.dao.HumanEntityRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceUser implements IServiceUser {
    private final HumanEntityRepositroy humanDao;
    private final CatsEntityRepositroy catsDao;
    private final FriendshipEntityRepository friendshipDao;

    @Autowired
    public ServiceUser(HumanEntityRepositroy humanDao, CatsEntityRepositroy catsDao, FriendshipEntityRepository friendshipDao) {
        this.humanDao = humanDao;
        this.catsDao = catsDao;
        this.friendshipDao = friendshipDao;
    }

    public Long addHuman(String name, Date dateBirthday) {
        HumanEntity human = new HumanEntity(name, dateBirthday);
        humanDao.saveAndFlush(human);
        return human.getId();
    }

    public Long addCats(String name, Date dateBirthday, ColorCat color, String breed, Long id) {
        CatsEntity cats = new CatsEntity(name, dateBirthday, color, breed);
        HumanEntity human = humanDao.getOne(id);
        cats.setHumanEntity(human);
        human.addCat(cats);
        catsDao.saveAndFlush(cats);
        return cats.getId();
    }

    public String getNameHuman(Long humanId) {
        HumanEntity human = humanDao.getOne(humanId);
        return human.getName();
    }

    public Date getDateHuman(Long humanId) {
        HumanEntity human = humanDao.getOne(humanId);
        return human.getDateBirthday();
    }

    public List<String> getHumanCats(Long humanId) {
        HumanEntity human = humanDao.getOne(humanId);
        List<String> catsToString = new ArrayList<>();
        for (CatsEntity cats : human.getCatsById()) {
            catsToString.add(cats.toString());
        }
        return catsToString;
    }

    public String getNameCat(Long catId) {
        CatsEntity cats = catsDao.getOne(catId);
        return cats.getName();
    }

    public String getColorCat(Long catId) {
        CatsEntity cats = catsDao.getOne(catId);
        return cats.getColor();
    }

    public String getBreedCat(Long catId) {
        CatsEntity cats = catsDao.getOne(catId);
        return cats.getBreed();
    }

    public String getCatHuman(Long catsId) {
        CatsEntity cats = catsDao.getOne(catsId);
        return cats.getHumanEntity().toString();
    }

    public void setNameHuman(Long humanId, String name) {
        HumanEntity human = humanDao.getOne(humanId);
        human.setName(name);
        humanDao.saveAndFlush(human);
    }

    public void setDateHuman(Long humanId, Date date) {
        HumanEntity human = humanDao.getOne(humanId);
        human.setDateBirthday(date);
        humanDao.saveAndFlush(human);
    }

    public void setNameCat(Long catId, String name) {
        CatsEntity cats = catsDao.getOne(catId);
        cats.setName(name);
        catsDao.saveAndFlush(cats);
    }

    public void setColorCat(Long catId, String color) {
        CatsEntity cats = catsDao.getOne(catId);
        cats.setColor(color);
        catsDao.saveAndFlush(cats);
    }

    public void setBreedCat(Long catId, String breed) {
        CatsEntity cats = catsDao.getOne(catId);
        cats.setBreed(breed);
        catsDao.saveAndFlush(cats);
    }

    public List<String> getCats() {
        List<String> allCats = new ArrayList<>();
        for (CatsEntity cat : catsDao.findAll()) {
            allCats.add(cat.toString());
        }
        return allCats;
    }

    public void addFriendShip(int catIdOne, int catIdTwo) {
        FriendshipEntity friendship = new FriendshipEntity(catIdOne, catIdTwo);
        friendshipDao.saveAndFlush(friendship);
    }

    public List<String> getHumans() {
        List<String> allHuman = new ArrayList<>();
        for (HumanEntity human : humanDao.findAll()) {
            allHuman.add(human.toString());
        }
        return allHuman;
    }

}
