package classes.memories;

/**
 *    Descrição geral:
 *       definição de uma excepção por acesso a uma memória de tipo stack ou fifo
 *       nas condições seguintes:
 *          - operação de escrita sobre uma memória cheia
 *          - operação de leitura sobre uma memória vazia.
 */

public class MemException extends Exception

{
  /**
   *  Construtor de variáveis
   */

   public MemException (String errorMessage)
   {
     super (errorMessage);
   }

   public MemException (String errorMessage, Throwable cause)
   {
     super (errorMessage, cause);
   }
}
