using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace _05_ByteBank
{
    public class ContaCorrente
    {
        public Cliente titular;

        public int agencia;
        public int numero;
        public double saldo;


        public bool Sacar(double valor)
        {
            if (this.saldo < valor)
            {
                return false;
            }
            else
            {
                this.saldo -= valor;
                return true;
            }
        }

        public void Depositar(double valor)
        {
            this.saldo += valor;
        }

        public bool Transferir(double valor, ContaCorrente contaDestino)
        {
            if (this.saldo < valor)
            {
                return false;
            }
            else
            {
                this.saldo -= valor;
                contaDestino.Depositar(valor);
                return true;
            }
        }
    }
}





/*
string titular = "Gabriela";
int numeroAgencia = 863;
int numero = 863146;
double saldo = 100;

string titular2 = "Bruno";
int numeroAgencia2 = 863;
int numero2 = 864;
double saldo2 = 50;
*/