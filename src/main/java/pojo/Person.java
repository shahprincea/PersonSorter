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

package pojo;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Date;

/**
 * POJO Person class
 */
public class Person {

    private String ssn;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Double heightIn;
    private Double weightLb;

    public Person(final String ssn, final Date dateOfBirth, final String firstName,
            final String lastName, final Double heightIn, final Double weightLb) {
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightIn = heightIn;
        this.weightLb = weightLb;
    }

    public String getSsn() {
        return ssn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getHeightIn() {
        return heightIn;
    }

    public Double getWeightLb() {
        return weightLb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equal(ssn, person.ssn) && Objects
                .equal(dateOfBirth, person.dateOfBirth) && Objects
                .equal(firstName, person.firstName) && Objects
                .equal(lastName, person.lastName) && Objects
                .equal(heightIn, person.heightIn) && Objects
                .equal(weightLb, person.weightLb);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ssn, dateOfBirth, firstName, lastName, heightIn,
                weightLb);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("ssn", ssn)
                .add("dateOfBirth", dateOfBirth).add("firstName", firstName)
                .add("lastName", lastName).add("heightIn", heightIn)
                .add("weightLb", weightLb).toString();
    }

}
