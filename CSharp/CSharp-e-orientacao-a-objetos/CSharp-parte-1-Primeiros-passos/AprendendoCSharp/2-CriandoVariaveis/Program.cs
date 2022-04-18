using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2_CriandoVariaveis
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Executando projeto 2 - Criando Variaveis");

            int idade;
            idade = 20; Console.WriteLine(idade);
            idade = 10; Console.WriteLine(idade);
            idade = 10 + 10; Console.WriteLine(idade);
            idade = 10 +  5; Console.WriteLine(idade);
            idade = 10 + 5 * 2; Console.WriteLine(idade);
            idade = (10 + 5) * 2; Console.WriteLine(idade);

            Console.WriteLine("a idade é " + idade + ", parabéns!");

            idade = (10 + 5) * 2; Console.Write(idade); //Nao pula linha del o "Line"


            Console.WriteLine("Execução finalizada. Tecle enter para sair...");
            Console.ReadLine();
        }
    }
}
