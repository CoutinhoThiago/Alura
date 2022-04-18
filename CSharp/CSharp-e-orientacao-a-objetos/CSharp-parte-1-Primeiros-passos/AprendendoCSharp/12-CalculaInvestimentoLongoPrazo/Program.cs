using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12_CalculaInvestimentoLongoPrazo
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Executando o projeto 12");

            double valorInvestido = 1000;
            double fatorDeRendimento = 1.0036;

            for (int contadorAno = 1; contadorAno <= 5; contadorAno++)
            {
                for (int contadorMes = 1; contadorMes <= 12; contadorMes++)
                {
                    valorInvestido *= fatorDeRendimento;
                }
                //contadorMes = 5;
                fatorDeRendimento += 0.010;
            }
            //Console.WriteLine("Tempo do investimento foi de " + contadorMes);
            Console.WriteLine("Ao termino do investimento, você terá R$" + valorInvestido);

            Console.ReadLine();
        }
    }
}
