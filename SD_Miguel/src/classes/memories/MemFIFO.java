package classes.memories;

/**
 *    Descrição geral:
 *       este tipo de dados define uma memória de tipo fifo derivada
 *       a partir de uma memória genérica que foi construída de uma forma paramétrica.
 */

public class MemFIFO<R> extends MemObject<R>
{
  /**
   *  Definição da memória de tipo fifo
   */

   private int inPnt = 0,                                  // ponteiro de inserção de um valor
               outPnt = 0;                                 // ponteiro de retirada de um valor
   private boolean empty = true;                           // sinalização de memória vazia

  /**
   *  Construtor de variáveis
   */

   public MemFIFO (int nElem)
   {
     super (nElem);
   }

  /**
   *  fifo in -- escrita de um valor
   */

    @Override
   public void write (R val) throws MemException
   {
     if ((inPnt != outPnt) || empty)
        { mem[inPnt] = val;
          inPnt += 1;
          inPnt %= nMax;
          empty = false;
          size++;
        }
        else throw new MemException ("Fifo full!");
   }

  /**
   *  fifo out -- leitura de um valor
   */

    @Override
   public R read () throws MemException
   {
     R val = null;

     if ((outPnt != inPnt) || !empty)
        { val = mem[outPnt];
          outPnt += 1;
          outPnt %= nMax;
          empty = (inPnt == outPnt);
          size--;
        }
        else throw new MemException ("Fifo empty!");
     return val;
   }
}
