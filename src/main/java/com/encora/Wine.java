package com.encora;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@AllArgsConstructor
@Data
class Wine implements Comparable<Wine> {

    private String name;
    private String kind;
    private Double pH;
    private Double alcohol;
    private int quality;

    @Override
    public int compareTo(Wine o) {
        // Compare by pH and kind
        return Comparator.comparing(Wine::getKind).thenComparing(Wine::getPH).compare(this, o);
    }
    /*
        @Override
        public int compareTo(Apple other) {
            int result = this.name.compareTo(other.name);
            if (result == 0) {
                result = this.pH.compareTo(other.pH);
            }
            if (result == 0) {
                result = Integer.compare(this.quality, other.quality);
            }
            return result;
        }

        @Override
        public int compareTo(Wine other) {
            if (this.pH < other.pH) {
                return -1;
            }
            if (this.pH.equals(other.pH)) {
                return 0;
            }
            return 1;
        }

        @Override
        public int compareTo(Wine other) {
            int result = this.name.compareTo(other.name);
            if (result == 0) {
                result = this.pH.compareTo(other.pH);
            }
            if (result == 0) {
                result = Integer.compare(this.quality, other.quality);
            }
            return result;
        }
    */

}
