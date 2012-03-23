package classes.memories;

/**
 *    Descrição geral:
 *       este tipo de dados define uma memória de tipo stack derivada
 *       a partir de uma memória genérica que foi construída de uma forma paramétrica.
 */

public class MemStack<R> extends MemObject<R>
{
  /**
   *  Definição da memória de tipo stack
   */

   private int stackPnt = 0;                               // stack pointer

  /**
   *  Construtor de variáveis
   */

   public MemStack (int nElem)
   {
     super (nElem);
   }

  /**
   *  stack push -- escrita de um valor
   */

   public void write (R val) throws MemException
   {
     if (stackPnt != nMax)
        { mem[stackPnt] = val;
          stackPnt += 1;
          size++;
        }
        else throw new MemException ("Stack full!");
   }

  /**
   *  stack pop -- leitura de um valor
   */

   public R read () throws MemException
   {
     if (stackPnt != 0) {
         
         stackPnt -= 1;
         size--;
          return (mem[stackPnt]);
        }
        else throw new MemException ("Stack empty!");
   }
}
