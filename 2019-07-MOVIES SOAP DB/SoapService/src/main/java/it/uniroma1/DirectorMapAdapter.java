/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class DirectorMapAdapter extends XmlAdapter<DirectorMap, Map<String,Director>>{

    public DirectorMapAdapter(){}
    @Override
    public Map<String,Director> unmarshal(DirectorMap v) throws Exception {
        Map<String,Director> boundMap = new LinkedHashMap<String, Director>();
        for (DirectorMap.DirectorEntry directorEntry : v.getEntries()) {
            boundMap.put(directorEntry.getId(), directorEntry.getDirector());
        }
        return boundMap;
    }

    @Override
    public DirectorMap marshal(Map<String, Director> boundMap) throws Exception {
        DirectorMap valueMap = new DirectorMap();
        for (Map.Entry<String, Director> boundEntry : boundMap.entrySet()) {
            DirectorMap.DirectorEntry valueEntry = new DirectorMap.DirectorEntry();
            valueEntry.setDirector(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }
    
}
