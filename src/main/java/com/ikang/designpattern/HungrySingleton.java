package com.ikang.designpattern;

import java.io.Serializable;

/**
 *
 * @author gaoyouzhi
 * @date 2020/2/20
 */
public class HungrySingleton {
    public static void main(String[] args) {

    }


}

class HungrySingle implements Serializable{

    private static final long serialVersionUID = 9023581638195677227L;

    private static HungrySingle instance = new HungrySingle();

    private HungrySingle(){}

    public static HungrySingle getInstance(){
        return instance;
    }

}
