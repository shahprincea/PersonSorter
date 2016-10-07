/*
 * Copyright 2016 Prince
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
import com.google.common.collect.Maps;
import pojo.Person;
import pojo.utils.comparator.DateOfBirthComparator;
import pojo.utils.comparator.FirstNameComparator;
import pojo.utils.comparator.HeightInComparator;
import pojo.utils.comparator.LastNameComparator;
import pojo.utils.comparator.SSNComparator;
import pojo.utils.comparator.WeightLbComparator;
import pojo.utils.exception.PersonSorterException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/*
 * Created by prince on 10/6/16.
 */
public class PersonSorter {

    private static Map<String, Comparator> sortedFieldMap;

    //TODO: Use enum instead of String in sortField
    //TODO: Change ascending from String to boolean
    /**
     * Sort person object based on sortField and ascending
     * <p>
     * <b>Note:</b> Add an entry to map with new custom comparator to extend
     *
     * @param people
     * @param sortField
     * @param ascending
     * @return
     */
    public static List<Person> sort(Iterable<Person> people, String sortField,
            String ascending) throws PersonSorterException {

        /**
         * Instead of using nested If else loop I used Map its much cleaner implementation
         *
         */
        //Lazy loading
        if (sortedFieldMap == null) {

            sortedFieldMap = Maps.newHashMap();
            sortedFieldMap.put("ssn", new SSNComparator());
            sortedFieldMap.put("dateOfBirth", new DateOfBirthComparator());
            sortedFieldMap.put("firstName", new FirstNameComparator());
            sortedFieldMap.put("lastName", new LastNameComparator());
            sortedFieldMap.put("heightIn", new HeightInComparator());
            sortedFieldMap.put("weightLb", new WeightLbComparator());
        }

        Comparator comparator = sortedFieldMap.get(sortField);
        if(comparator == null) {
            throw new PersonSorterException("Check SortField value..... no comparator found");
        }
        boolean isAscending = ascending.equalsIgnoreCase("true");
        List<Person> listOfPeople = Lists.newArrayList(people);

        if (isAscending) {
            Collections.sort(listOfPeople, comparator);
        } else {
            Collections.sort(listOfPeople,
                    Collections.reverseOrder(comparator));
        }
        return listOfPeople;
    }

}
