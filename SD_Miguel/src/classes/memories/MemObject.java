package classes.memories;

/**
 *    Descrição geral:
 *       este tipo de dados define uma memória genérica que foi construída de uma forma paramétrica.
 */

public abstract class MemObject<R>

{
    
  /**
   *  Definição da memória genérica
   */

    protected static final int DEFAULT_SIZE = 100;
   protected int nMax = 0;                                 // tamanho da memória
   protected R [] mem = null;                              // área de armazenamento
   protected int size = 0;
   protected boolean limited = true;
   
  /**
   *  Construtor de variáveis
   */
   
   protected MemObject () {
       this(DEFAULT_SIZE);
       limited = false;
   }
   protected MemObject (int nElem)
   {
       assert nElem > 0;
     mem = (R []) new Object [nElem];
     nMax = nElem;
   }

  /**
   *  escrita de um valor -- método virtual
   */

   public abstract void write (R val) throws MemException;

  /**
   *  leitura de um valor -- método virtual
   */

   public abstract R read () throws MemException;
   
   
   public final boolean isLimited() { return limited; }
   public final boolean isFull () { return limited && size == nMax; }
   public final boolean isEmpty () { return size == 0; }
   public final int size() { return size; }
   public final int maxSize () {
       assert isLimited();
       
       return nMax;
   }
}
