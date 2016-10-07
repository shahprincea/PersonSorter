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
public class WeightLbComparatorTest {
    @Test
    public void compareByWeightAscendingDescending() throws Exception {

        Person p1 = new Person(null, null, "Alex", "Peterson", 72d, 200d);
        Person p2 = new Person(null, null, "John", "Tough", 72.5d, 220d);
        Person p3 = new Person(null, null, "Yo", "Honda", 75d, 247d);

        List<Person> people = Lists.newArrayList();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        Collections.sort(people, new WeightLbComparator());
        assertTrue(people.get(0).getWeightLb() == 200d);
        assertTrue(people.get(1).getWeightLb() == 220d);
        assertTrue(people.get(2).getWeightLb() == 247d);

        Collections.sort(people,
                Collections.reverseOrder(new WeightLbComparator()));
        assertTrue(people.get(2).getWeightLb() == 200d);
        assertTrue(people.get(1).getWeightLb() == 220d);
        assertTrue(people.get(0).getWeightLb() == 247d);
    }

}