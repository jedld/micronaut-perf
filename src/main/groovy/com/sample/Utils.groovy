package com.sample

import java.util.concurrent.ThreadLocalRandom

class Utils {

    static getRandom(int i){
        ThreadLocalRandom.current().nextInt(i)
    }
}
