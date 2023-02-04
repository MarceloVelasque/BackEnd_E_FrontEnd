let idForm, descrForm, qtdForm, vlrForm;
const sURL = 'http://localhost:8081/api/produtos/';

window.onload = function (e) {
    idForm = document.querySelector('#iID');
    nomeForm = document.querySelector('#iNome');
    nomeDeDependentesForm = document.querySelector('#iNumeroDeDependentes');
    salarioForm = document.querySelector('#iSalario');
};

async function incluirFuncionario() {
    const id = idForm.value;
    const nome = nomeForm.value; 
    const numeroDeDependentes = numeroDeDependentesForm.value;
    const salario = salarioForm.value;

    axios.post(sURL, { id, nome, numeroDeDependentes, salario})
        .then(res => {
            res.data.toString = function() {
                return 'ID: ' + this.id + '\nNome: ' + this.nome +
                    '\nNumeroDeDependentes: ' + this.nome + '\nSalario: ' + this.salario;
                }

            alert(res.data.toString());
            console.log(res.data);
            setTimeout(() => window.location.href = '/', 100);
        })
        .catch(res => console.log(res.response.data));
}