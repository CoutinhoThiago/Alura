using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_ByteBank
{
    class Program
    {
        static void Main(string[] args)
        {
            /*ContaCorrente contaDoBruno = new ContaCorrente();

            contaDoBruno.titular = "Bruno";

            Console.WriteLine(contaDoBruno.saldo);

            //contaDoBruno.Sacar(50);
            bool resultadoSaque = contaDoBruno.Sacar(50);

            Console.WriteLine(contaDoBruno.saldo);
            Console.WriteLine(resultadoSaque);
            
             Console.ReadLine();*/

            Cliente gabriela = new Cliente();
                gabriela.nome = "Gabriela";
                gabriela.profissao = "Desenvolvedora C#";
                gabriela.cpf = "434.562.878-20";

            ContaCorrente conta = new ContaCorrente();
                conta.titular = gabriela;
                conta.saldo = 500;
                conta.agencia = 563;
                conta.numero = 5634527;

            Console.WriteLine(gabriela.nome);

            
        }
    }
}
