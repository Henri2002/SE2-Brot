package de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih;

import java.util.ArrayList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Vormerkkarte;

public class IndexBasedQueue<T>
{
    private List<Vormerkkarte> queue;

    public IndexBasedQueue()
    {
        queue = new ArrayList<Vormerkkarte>();
    }

    public void enqueue(Vormerkkarte vormerkkarte)
    {
        queue.add(vormerkkarte);
    }

    public Vormerkkarte dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);
    }

    public Vormerkkarte get(int index)
    {
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return queue.get(index);
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    public int size()
    {
        return queue.size();
    }
}