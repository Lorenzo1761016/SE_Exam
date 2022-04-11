/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1;

/**
 *
 * @author biar
 */
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author biar
 */
public class DirectorAdapter extends XmlAdapter<DirectorImpl,Director>{
    public DirectorImpl marshal(Director director) throws Exception {
        if (director instanceof DirectorImpl)
            return (DirectorImpl) director;
        return new DirectorImpl(director.getId(), director.getName(), director.getYear());
    }

    @Override
    public Director unmarshal(DirectorImpl v) throws Exception {
        return v;
    }
    
    public DirectorAdapter(){}
    
}