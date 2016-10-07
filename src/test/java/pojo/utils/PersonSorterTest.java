/*
 * Copyright [yyyy] [name of copyright owner]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pojo.utils;

import com.google.common.collect.Lists;
import org.junit.Test;
import pojo.Person;
import pojo.utils.comparator.FirstNameComparator;
import pojo.utils.comparator.LastNameComparator;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by prince on 10/6/16.
 */
public class PersonSorterTest {

    @Test
    public void sortOnFirstName() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("11/20/1984"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "firstName", "true");
        Collections.sort(people, new FirstNameComparator());
        assertTrue(people.get(0).getFirstName().equals("Alex"));
        assertTrue(people.get(1).getFirstName().equals("John"));
        assertTrue(people.get(2).getFirstName().equals("Yo"));

        people = PersonSorter.sort(people, "firstName", "false");
        assertTrue(people.get(2).getFirstName().equals("Alex"));
        assertTrue(people.get(1).getFirstName().equals("John"));
        assertTrue(people.get(0).getFirstName().equals("Yo"));

    }

    @Test
    public void sortOnLastName() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("11/20/1984"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "lastName", "true");
        Collections.sort(people, new LastNameComparator());
        assertTrue(people.get(0).getLastName().equals("Honda"));
        assertTrue(people.get(1).getLastName().equals("Peterson"));
        assertTrue(people.get(2).getLastName().equals("Tough"));

        people = PersonSorter.sort(people, "lastName", "false");
        assertTrue(people.get(2).getLastName().equals("Honda"));
        assertTrue(people.get(1).getLastName().equals("Peterson"));
        assertTrue(people.get(0).getLastName().equals("Tough"));

    }

    @Test
    public void sortOnSSN() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("11/20/1984"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "ssn", "true");
        assertTrue(people.get(0).getSsn().equals("111111111"));
        assertTrue(people.get(1).getSsn().equals("222222211"));
        assertTrue(people.get(2).getSsn().equals("222233333"));

        people = PersonSorter.sort(people, "ssn", "false");
        assertTrue(people.get(2).getSsn().equals("111111111"));
        assertTrue(people.get(1).getSsn().equals("222222211"));
        assertTrue(people.get(0).getSsn().equals("222233333"));

    }

    @Test
    public void sortOnDateOfBirth() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("11/20/1984"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "dateOfBirth", "true");
        assertTrue(people.get(0).getFirstName().equals("Alex"));
        assertTrue(people.get(1).getFirstName().equals("John"));
        assertTrue(people.get(2).getFirstName().equals("Yo"));

        people = PersonSorter.sort(people, "dateOfBirth", "false");
        assertTrue(people.get(2).getFirstName().equals("Alex"));
        assertTrue(people.get(1).getFirstName().equals("John"));
        assertTrue(people.get(0).getFirstName().equals("Yo"));

    }

    @Test
    public void sortOnHeightIn() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person(null, null, "Alex", "Peterson", 72d, 200d);
        Person p2 = new Person(null, null, "John", "Tough", 72.5d, 220d);
        Person p3 = new Person(null, null, "Yo", "Honda", 75d, 247d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "heightIn", "true");
        assertTrue(people.get(0).getHeightIn() == 72d);
        assertTrue(people.get(1).getHeightIn() == 72.5d);
        assertTrue(people.get(2).getHeightIn() == 75d);

        people = PersonSorter.sort(people, "heightIn", "false");
        assertTrue(people.get(2).getHeightIn() == 72d);
        assertTrue(people.get(1).getHeightIn() == 72.5d);
        assertTrue(people.get(0).getHeightIn() == 75d);

    }

    @Test
    public void sortOnWeightLb() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person(null, null, "Alex", "Peterson", 72d, 200d);
        Person p2 = new Person(null, null, "John", "Tough", 72.5d, 220d);
        Person p3 = new Person(null, null, "Yo", "Honda", 75d, 247d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "weightLb", "true");
        assertTrue(people.get(0).getWeightLb() == 200d);
        assertTrue(people.get(1).getWeightLb() == 220d);
        assertTrue(people.get(2).getWeightLb() == 247d);

        people = PersonSorter.sort(people, "weightLb", "false");
        assertTrue(people.get(2).getWeightLb() == 200d);
        assertTrue(people.get(1).getWeightLb() == 220d);
        assertTrue(people.get(0).getWeightLb() == 247d);

    }

    @Test
    public void sortOnEmptyList() throws Exception {

        List<Person> people = Lists.newArrayList();
        people = PersonSorter.sort(people, "firstName", "true");
        assertTrue(true);
    }

    @Test
    public void sortOnDuplicateFirstName() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("11/20/1984"), "Alex", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "firstName", "true");
        Collections.sort(people, new FirstNameComparator());
        assertTrue(people.get(0).getFirstName().equals("Alex"));
        assertTrue(people.get(1).getFirstName().equals("Alex"));
        assertTrue(people.get(2).getFirstName().equals("Yo"));

        people = PersonSorter.sort(people, "firstName", "false");
        assertTrue(people.get(2).getFirstName().equals("Alex"));
        assertTrue(people.get(1).getFirstName().equals("Alex"));
        assertTrue(people.get(0).getFirstName().equals("Yo"));

    }

    @Test
    public void sortOnDuplicateLastName() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Honda", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("11/20/1984"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "lastName", "true");
        Collections.sort(people, new LastNameComparator());
        assertTrue(people.get(0).getLastName().equals("Honda"));
        assertTrue(people.get(1).getLastName().equals("Honda"));
        assertTrue(people.get(2).getLastName().equals("Tough"));

        people = PersonSorter.sort(people, "lastName", "false");
        assertTrue(people.get(2).getLastName().equals("Honda"));
        assertTrue(people.get(1).getLastName().equals("Honda"));
        assertTrue(people.get(0).getLastName().equals("Tough"));

    }

    @Test
    public void sortOnDuplicateSSN() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("111111111", df.parse("11/20/1984"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "ssn", "true");
        assertTrue(people.get(0).getSsn().equals("111111111"));
        assertTrue(people.get(1).getSsn().equals("111111111"));
        assertTrue(people.get(2).getSsn().equals("222233333"));

        people = PersonSorter.sort(people, "ssn", "false");
        assertTrue(people.get(2).getSsn().equals("111111111"));
        assertTrue(people.get(1).getSsn().equals("111111111"));
        assertTrue(people.get(0).getSsn().equals("222233333"));

    }

    @Test
    public void sortOnDuplicateDateOfBirth() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person("111111111", df.parse("10/18/1988"), "Alex",
                "Peterson", 0d, 0d);
        Person p2 =
                new Person("222222211", df.parse("10/18/1988"), "John", "Tough",
                        0d, 0d);
        Person p3 =
                new Person("222233333", df.parse("12/06/1980"), "Yo", "Honda",
                        0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "dateOfBirth", "true");
        assertTrue(people.get(2).getFirstName().equals("Yo"));

        people = PersonSorter.sort(people, "dateOfBirth", "false");
        assertTrue(people.get(0).getFirstName().equals("Yo"));

    }

    @Test
    public void sortOnDuplicateHeightIn() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person(null, null, "Alex", "Peterson", 72.5d, 200d);
        Person p2 = new Person(null, null, "John", "Tough", 72.5d, 220d);
        Person p3 = new Person(null, null, "Yo", "Honda", 75d, 247d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "heightIn", "true");
        assertTrue(people.get(0).getHeightIn() == 72.5d);
        assertTrue(people.get(1).getHeightIn() == 72.5d);
        assertTrue(people.get(2).getHeightIn() == 75d);

        people = PersonSorter.sort(people, "heightIn", "false");
        assertTrue(people.get(2).getHeightIn() == 72.5d);
        assertTrue(people.get(1).getHeightIn() == 72.5d);
        assertTrue(people.get(0).getHeightIn() == 75d);

    }

    @Test
    public void sortOnDuplicateWeightLb() throws Exception {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Person p1 = new Person(null, null, "Alex", "Peterson", 72d, 220d);
        Person p2 = new Person(null, null, "John", "Tough", 72.5d, 220d);
        Person p3 = new Person(null, null, "Yo", "Honda", 75d, 247d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        people = PersonSorter.sort(people, "weightLb", "true");
        assertTrue(people.get(0).getWeightLb() == 220d);
        assertTrue(people.get(1).getWeightLb() == 220d);
        assertTrue(people.get(2).getWeightLb() == 247d);

        people = PersonSorter.sort(people, "weightLb", "false");
        assertTrue(people.get(2).getWeightLb() == 220d);
        assertTrue(people.get(1).getWeightLb() == 220d);
        assertTrue(people.get(0).getWeightLb() == 247d);

    }
}