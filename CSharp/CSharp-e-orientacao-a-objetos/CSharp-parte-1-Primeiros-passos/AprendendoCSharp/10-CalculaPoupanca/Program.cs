﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_CalculaPoupanca
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Executando projeto 10 - Calcula poupança");

            //nt valorInvestido = 1000;
            double valorInvestido = 1000.0;

            int contadorMes = 1;
            /*while (contadorMes <= 12)
            {
                Console.WriteLine("Executando projeto 10 - Calcula poupança");

                //nt valorInvestido = 1000;
                double valorInvestido = 1000.0;




                valorInvestido = valorInvestido + valorInvestido * 0.0036;
                Console.WriteLine("Após " + contadorMes + " meses, você terá R$" + valorInvestido);

                // contadorMes = contadorMes + 1;
                contadorMes += 1;
            }*/
            while (contadorMes < 12)
            {
                valorInvestido = valorInvestido + valorInvestido * 0.0036;
                Console.WriteLine("Após " + contadorMes + " meses, você terá R$" + valorInvestido);

                // contadorMes = contadorMes + 1;
                contadorMes += 1;
            }
            Console.WriteLine("Após 1 ano você terá R$" + valorInvestido);

            Console.ReadLine();
        }
    }
}
