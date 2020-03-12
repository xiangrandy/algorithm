package 排序;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Olympic Game
 * 
 * @author x00418543
 * @since 2020年1月15日
 */
public class OlympicGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        List<MedalMessage> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            String[] m = line.split(" ");
            MedalMessage message = new MedalMessage(m[0], Integer.parseInt(m[1]), Integer.parseInt(m[2]),
                    Integer.parseInt(m[3]));
            l.add(message);
        }
        Collections.sort(l);
        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.println(l.get(i).country);
        }
    }

}

class MedalMessage implements Comparable<MedalMessage> {
    public String country;

    public int goldMedal;

    public int silverMedal;

    public int bronzeMedal;

    public MedalMessage(String country, int goldMedal, int silverMedal, int bronzeMedal) {
        super();
        this.country = country.trim();
        this.goldMedal = goldMedal;
        this.silverMedal = silverMedal;
        this.bronzeMedal = bronzeMedal;
    }

    @Override
    public int compareTo(MedalMessage o) {
        int result = compareMedal(this.goldMedal, o.goldMedal);
        if (result != 0) {
            return result;
        }
        result = compareMedal(this.silverMedal, o.silverMedal);
        if (result != 0) {
            return result;
        }
        result = compareMedal(this.bronzeMedal, o.bronzeMedal);
        if (result != 0) {
            return result;
        }
        return compareCountry(this.country, o.country);
    }

    private int compareCountry(String countryThis, String countryOther) {
        if (countryThis.compareTo(countryOther) < 0) {
            return 1;
        } else if (countryThis.compareTo(countryOther) > 0) {
            return -1;
        } else {
            return 0;
        }
    }

    private int compareMedal(int medalThis, int medal) {
        if (medalThis < medal) {
            return -1;
        } else if (medalThis > medal) {
            return 1;
        } else {
            return 0;
        }
    }
}
