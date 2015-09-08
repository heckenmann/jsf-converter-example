package de.heckenmann.jsfconverter;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Diese Klasse simuliert die Verbindung zur Datenbank.
 * @author Ben
 *
 */
@Singleton
@LocalBean
public class MyDao implements Serializable {

    private static final long serialVersionUID = -1L;

    private Map<Integer, ClassToConvert> storage;

    /**
     * Gibt alle Werte zurück, die in der Liste stehen.
     * @return
     */
    public Collection<ClassToConvert> getAll() {
        return this.storage.values();
    }

    /**
     * Sucht den Eintrag hinter der Id.
     * @param id
     * @return
     */
    public ClassToConvert getById(final int id) {
        return this.storage.get(id);
    }

    @PostConstruct
    public void init() {
        final int storSize = 15;
        this.storage = new HashMap<>(storSize);

        // Liste mit Werten füllen
        IntStream.range(0, storSize).forEach(i -> this.storage.put(i, new ClassToConvert(i, "Instanz: " + i)));
    }
}