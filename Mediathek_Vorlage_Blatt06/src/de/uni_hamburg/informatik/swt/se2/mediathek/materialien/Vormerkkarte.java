package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * NOCH NICHT FERTIG
 * @author Brot
 * @version SoSe 2023
 */
public class Vormerkkarte
{

    // Eigenschaften einer Vormerkkarte
    private final Queue<Kunde> _vormerker;

    /**
     * Initialisert eine neue Vormerkkarte mit den gegebenen Daten.
     * 
     * @param entleiher Ein Kunde, der das Medium vormerken möchte.
     * @param medium Das Medium, welches vorgemerkt werden soll.
     * 
     * 
     * @require medium != null
     * 
     * 
     * @ensure #getEntleiher() == entleiher
     * @ensure #getMedium() == medium
     * 
     */
    public Vormerkkarte(Medium medium)
    {
        assert medium != null : "Vorbedingung verletzt: medium != null";

        _vormerker = new ArrayBlockingQueue<Kunde>(3);
    }

    /**
     * Gibt den Vormerker zurück.
     * 
     * @return den Kunden, der das Medium vorgemerkt hat.
     * 
     * @ensure result != null
     */
    public Kunde getErstenVormerker()
    {
        Kunde kunde = _vormerker.peek();
        return kunde;
    }

    public Kunde getZweitenVormerker()
    {
        Queue<Kunde> tempQueue = new ArrayBlockingQueue<Kunde>(3);
        tempQueue.addAll(_vormerker);
        tempQueue.poll();
        Kunde kunde = tempQueue.peek();
        return kunde;
    }

    public Kunde getDrittenVormerker()
    {
        Queue<Kunde> tempQueue = new ArrayBlockingQueue<Kunde>(3);
        tempQueue.addAll(_vormerker);
        tempQueue.poll();
        tempQueue.poll();
        Kunde kunde = tempQueue.peek();
        return kunde;
    }

    public int getSize()
    {
        return _vormerker.size();
    }

    public void enqueue(Kunde kunde)
    {
        assert _vormerker
            .size() <= 3 : "Vorbedingung verletzt: _vormerker.size() <= 3 ";
        _vormerker.add(kunde);
    }

    public Kunde dequeue()
    {
        return _vormerker.poll();
    }

    public boolean pruefeObKundeEnthalten(Kunde kunde)
    {
        return _vormerker.contains(kunde);
    }

}
