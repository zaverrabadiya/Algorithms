package com.zavrab.adhoc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Given n required pick up locations for car pool for a single trip,
// and a list of potential people to pick up per location.
// List all unique combinations of people that could be taken on this trip.
// Each location is represented as a comma separated string of people.
// Return the a list of strings where each string represents one possible trip.
// You can only pick up one person per location.
//
// locations = [
//     "person1, person2, person3, person4, person5",
//     "person6, person7, person8, person9, person10",
//     "person11, person12, person13",
//     "person14, person15"
// ]
//
// outputs:
// [
//      "person1, person6, person11, person14",
//      "person1, person6, person11, person15",
//       ....
// ]
public class Main {

    public static void main(String[] args) {
        List<String>[] locations = new ArrayList[4];

        locations[0] = new ArrayList<String>(Arrays.asList("p1", "p2", "p3", "p4", "p5"));
        locations[1] = new ArrayList<String>(Arrays.asList("p6", "p7", "p8", "p9", "p10"));
        locations[2] = new ArrayList<String>(Arrays.asList("p11", "p12", "p13"));
        locations[3] = new ArrayList<String>(Arrays.asList("p14", "p15"));

        List<List<String>> result = pickUpList(locations);
    }

    public static List<List<String>> pickUpList(List<String>[] locations) {
        List<List<String>> result = new ArrayList<List<String>>();

        pickUpPersons(locations, 0, result, new ArrayList<String>());

        return result;
    }

    private static void pickUpPersons(List<String>[] locations, int locIdx, List<List<String>> result, List<String> persons) {

        if (locIdx == locations.length) {
            result.add(new ArrayList<String>(persons));
            return;
        }

        for (int i = 0; i < locations[locIdx].size(); i++) {
            persons.add(locations[locIdx].get(i));

            pickUpPersons(locations, locIdx + 1, result, persons);

            persons.remove(persons.size()-1);
        }
    }
}
