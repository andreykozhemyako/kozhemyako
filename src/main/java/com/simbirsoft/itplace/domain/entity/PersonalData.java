package com.simbirsoft.itplace.domain.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.util.Arrays.*;

//Хранилище
public class PersonalData {
    //Свойства
    private String FIO;                     //ФИО
    private String DOB;                     //Дата рождения
    private String phone;                   //телефон
    private String email;                   //электронная почта
    private String skype;                   //скайп
    private String avatar;                  //ссылка на аватарку
    private String target;                  //цель
    private String experiences;             //опыт работы
    private String educations;              //образование
    private String additionalEducations;    //дополнительное образование
    private String skills;                  //скилы

    public LinkedHashMap <String, Integer> skillsMap = new LinkedHashMap <>();


    // примеры кода
    public PersonalData(String FIO, String DOB, String phone, String email, String skype, String avatar, String target, String experiences, String educations, String additionalEducations, String skills) {
        this.FIO = FIO;
        this.DOB = DOB;
        this.phone = phone;
        this.email = email;
        this.skype = skype;
        this.avatar = avatar;
        this.target = target;
        this.experiences = experiences;
        this.educations = educations;
        this.additionalEducations = additionalEducations;
        this.skills = skills;

    }


    public void readPropertyFile()  {
        Properties prop = new Properties();
        InputStream input;
        TreeMap <String, Integer> propvals = new TreeMap <>();
        try {

            input = PersonalData.class.getResourceAsStream("/person.properties");
            prop.load(input);
            //String Skills = new String(prop.getProperty("skills").getBytes("ISO8859-1"));
            String[] strings = skills.split(", ");
            for (int i = 0; i < strings.length; i++) {
                String[] elements = strings[i].split(":");
                skillsMap.put(elements[0], Integer.parseInt(elements[1]));
            }
            sortByValue(skillsMap);

            //System.out.println(MaxPosition(propvals));
            //System.out.println(propvals);
            //System.out.println("TreeMap generated::" + propvals);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static <K, V extends Comparable <? super V>> Map <K, V> sortByValue(Map <K, V> map) {
        List <Map.Entry <K, V>> list = new LinkedList <>(map.entrySet());
        Collections.sort(list, new Comparator <Map.Entry <K, V>>() {
            @Override
            public int compare(Map.Entry <K, V> o1, Map.Entry <K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map <K, V> result = new LinkedHashMap <>();
        for (Map.Entry <K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }







    /*private void stringToArray(){

        String [] skillsArray = skills.split(",");

        sort(skillsArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int s1 = Integer.parseInt(o1.substring(o1.indexOf(":") + 1));
                int s2 = Integer.parseInt(o2.substring(o2.indexOf(":") + 1));
                return s2 - s1;
            }
        });

        for(String s : skillsArray){
            String [] tmp = s.split(":");
            System.out.println(s);
            skillsMap.put(tmp[0],Integer.parseInt(tmp[1]));
        }

    }

    public void makeSplit(){

        stringToArray();
    }*/



    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatarPath(String avatar) {
        this.avatar = avatar;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    public String getAdditionalEducations() {
        return additionalEducations;
    }

    public void setAdditionalEducations(String additionalEducations) {
        this.additionalEducations = additionalEducations;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
