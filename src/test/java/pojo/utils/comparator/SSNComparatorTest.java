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

package pojo.utils.comparator;

import com.google.common.collect.Lists;
import org.junit.Test;
import pojo.Person;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by prince on 10/6/16.
 */
public class SSNComparatorTest {

    @Test
    public void compareBySSNAscendingDescending() throws Exception {
        Person p1 = new Person("111111111", null, "Alex", "Peterson", 0d, 0d);
        Person p2 = new Person("222222211", null, "John", "Tough", 0d, 0d);
        Person p3 = new Person("222233333", null, "Yo", "Honda", 0d, 0d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        Collections.sort(people, new SSNComparator());
        assertTrue(people.get(0).getSsn().equals("111111111"));
        assertTrue(people.get(1).getSsn().equals("222222211"));
        assertTrue(people.get(2).getSsn().equals("222233333"));

        Collections.sort(people,
                Collections.reverseOrder(new SSNComparator()));
        assertTrue(people.get(2).getSsn().equals("111111111"));
        assertTrue(people.get(1).getSsn().equals("222222211"));
        assertTrue(people.get(0).getSsn().equals("222233333"));
    }

}