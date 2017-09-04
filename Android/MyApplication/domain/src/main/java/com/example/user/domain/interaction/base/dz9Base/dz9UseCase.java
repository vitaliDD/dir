package com.example.user.domain.interaction.base.dz9Base;

/**
 * Created by user on 11.08.2017.
 */
abstract  public class dz9UseCase<InParam, OutParam> {

    abstract protected OutParam buildUseCase();


    public OutParam execute(){
        return buildUseCase();


    }


}
