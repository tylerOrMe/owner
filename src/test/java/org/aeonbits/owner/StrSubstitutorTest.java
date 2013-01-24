/*
 * Copyright (c) 2012, Luigi R. Viggiano
 * All rights reserved.
 *
 * This software is distributable under the BSD license.
 * See the terms of the BSD license in the documentation provided with this software.
 */

package org.aeonbits.owner;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Luigi R. Viggiano
 */
public class StrSubstitutorTest {

    @Test
    public void shouldReturnNullWhenNullIsProvided() {
        Map<String, String> map = Collections.emptyMap();
        StrSubstitutor substitutor = new StrSubstitutor(map);
        assertNull(substitutor.replace(null));
    }

    @Test
    public void shouldReplaceVariables() {
        Map<String, String> valuesMap = new HashMap<String, String>();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        assertEquals("The quick brown fox jumped over the lazy dog.", resolvedString);
    }

    @Test
    public void testRecoursiveResolution() {
        Map<String, String> valuesMap = new HashMap<String, String>();
        valuesMap.put("color", "brown");
        valuesMap.put("animal", "quick ${color} fox");
        valuesMap.put("target.attribute", "lazy");
        valuesMap.put("target.animal", "dog");
        valuesMap.put("target", "${target.attribute} ${target.animal}");
        valuesMap.put("template", "The ${animal} jumped over the ${target}.");
        String templateString = "${template}";
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        assertEquals("The quick brown fox jumped over the lazy dog.", resolvedString);
    }

}
