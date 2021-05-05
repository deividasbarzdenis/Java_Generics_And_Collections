package org.designPatterns.subject_Observer.Ex9_10.Currency_converter;


import java.util.Vector;

public class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

    private boolean changed = false;
    private Vector<Observer> obs = new Vector<>();

    public void addObserver(O o) {
        if (o == null)
            throw new StubException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    protected void clearChanged() throws StubException{
        changed = false;
    }

    public int countObservers() throws StubException{
        return obs.size();
    }

    public void deleteObserver(O o) throws StubException{
        obs.removeElement(o);
    }

    public boolean hasChanged() throws StubException{
        return changed;
    }

    public void notifyObservers() throws StubException{
        notifyObservers(null);
    }

    public void notifyObservers(A a) throws StubException{
        Object[] arrLocal;
        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }
        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, a);
    }

    protected void setChanged() throws StubException{
        changed = true;
    }
}
