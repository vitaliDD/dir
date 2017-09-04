package com.example.user.domain.interaction.base.dz9Base;

import com.example.user.domain.entity.dz9Entity.LinkModel;

import java.util.ArrayList;

/**
 * Created by user on 11.08.2017.
 */
public class LinkUseCase extends dz9UseCase<Void, LinkModel> {


    @Override
    protected LinkModel buildUseCase() {

        ArrayList<String> strings=new ArrayList<>();

        strings.add("http://mobi.pro-z.net/images/pictures/cartoons_026.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/indication_007.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/cinema_023.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/indication_024.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/erotic_049.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/cartoons_023.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/cartoons_101.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/auto_013.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/cartoons_026.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/indication_007.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/cinema_023.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/indication_024.jpg");
        strings.add("http://mobi.pro-z.net/images/pictures/erotic_049.jpg");

        LinkModel linkModel=new LinkModel(strings);
        return linkModel;
    }
}
