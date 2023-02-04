let id, idForm, descrForm, qtdForm, vlrForm;
const sURL = 'http://localhost:8081/api/produtos/';

window.onload = async function (e) {
    const query = window.location.search;
    const parametros = new URLSearchParams(query);
    id = parametros.get('id');

    idForm = document.querySelector('#iID');
    descrForm = document.querySelector('#iDescricao');
    qtdForm = document.querySelector('#iQuantidade');
    vlrForm = document.querySelector('#iValor');

    const produto = await buscarProduto(id);
    preencherForm(produto);
};

function preencherForm(funcionario) {
    idForm.value = produto.id;
    descrForm.value = produto.descricao;
    qtdForm.value = produto.quantidade;
    vlrForm.value = produto.valor;
}

async function buscarFuncionario(id) {
    const resposta = await axios.get(sURL + id);

    return resposta.data;
}

async function alterarFuncionario() {
    const id = idForm.value;
    const descricao = descrForm.value; listar
    const quantidade = qtdForm.value;
    const valor = vlrForm.value;

    axios.put(sURL, { id, nome, numeroDeDependentes, salario })
        .then(res => {
            alert(JSON.stringify(res.data));
            console.log(res.data);
            setTimeout(() => window.location.href = '/', 100);
        })
        .catch(res => console.log(res.response.data));
}