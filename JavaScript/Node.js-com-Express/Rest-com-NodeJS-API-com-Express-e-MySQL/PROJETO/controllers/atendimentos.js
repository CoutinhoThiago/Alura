const moment = require("moment")
const atendimentos = require("../models/atendimentos")

const Atendimento = require("../models/atendimentos")

module.exports = app =>
{
    app.get("/atendimentos", (req, res) => 
    {
        //res.send("Você está na rota de atendimentos e está realizando um GET")
        Atendimento.lista(res)
    })

    app.get("/atendimentos/:id", (req, res) => 
    {
        //console.log(req.params)

        const id = parseInt(req.params.id);

        atendimentos.buscaPorId(id,res)
        //res.send("OK")
    })
    
    app.post("/atendimentos", (req, res) => 
    {
        const atendimento = req.body
        
        Atendimento.adiciona(atendimento, res)
        console.log("Atendimento enviado")
        console.log(atendimento)
        //res.send("Post atendimento")

    }) 
    
    app.patch("/atendimentos/:id", (req, res) => 
    {
        const id = parseInt(req.params.id);
        const valores =  req.boddy

        atendimentos.altera(id, valores, res)
    })

    app.delete("/atendimentos/:id", (req, res) => 
    {
        const id = parseInt(req.parms.id)
        Atendimento.deleta(id, res)
    })
}