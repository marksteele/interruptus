package org.cad.interruptus.entity;

import com.google.common.hash.Hashing;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Type implements Entity
{
    protected List<TypeProperty> properties;
    protected String name;

    public Type()
    {
    }

    public Type(String name, List<TypeProperty> properties)
    {
        this.name       = name;
        this.properties = properties;
    }
    
    @Override
    public String getId()
    {
        return name;
    }
 
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<TypeProperty> getProperties()
    {
        return properties;
    }

    public void setProperties(List<TypeProperty> properties)
    {
        this.properties = properties;
    }

    public void addProperties(TypeProperty property)
    {
        this.properties.add(property);
    }

    @Override
    public String toString()
    {
        return String.format("{name:'%s', properties:%s}", name, properties);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash     = 13 * hash + Objects.hashCode(this.properties);
        hash     = 13 * hash + Objects.hashCode(this.name);

        return hash;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (obj == null) {
            return false;
        }

        if ( ! getClass().equals(obj.getClass())) {
            return false;
        }

        final Type other = (Type) obj;

        if ( ! Objects.equals(this.name, other.name)) {
            return false;
        }

        return Objects.equals(this.properties, other.properties);
    }
}
