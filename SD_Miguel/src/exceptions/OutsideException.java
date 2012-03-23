package exceptions;

/**
 *    Descrição geral:
 *       definição de uma excepção por acesso a uma memória de tipo stack ou fifo
 *       nas condições seguintes:
 *          - operação de escrita sobre uma memória cheia
 *          - operação de leitura sobre uma memória vazia.
 */

public class OutsideException extends Exception

{
  /**
   *  Construtor de variáveis
   */

   public OutsideException (String errorMessage)
   {
     super (errorMessage);
   }

   public OutsideException (String errorMessage, Throwable cause)
   {
     super (errorMessage, cause);
   }
}
