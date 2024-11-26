// Função para buscar todos os monitores e atualizar a tabela
function buscarMonitores() {
    fetch("http://localhost:8080/api/monitor")
        .then(res => res.json())
        .then(res => exibirMonitores(res))
        .catch(err => alert("Erro: " + err.message));
}


function exibirMonitores(monitorList) {
    let tabela = "<table>";
    tabela += "<tr><th>Nome</th><th>Tipo</th><th>Tamanho</th><th>Preço</th></tr>";
    monitorList.forEach(monitor => {
        tabela += `<tr>
            <td>${monitor.nome}</td>
            <td>${monitor.tipo}</td>
            <td>${monitor.tamanho}</td>
            <td>${monitor.preco}</td>
            <td>
                <a href="MonitorVisualizar.html?id=${monitor.id}">Detalhes</a>
                <a href="MonitorAlterar.html?id=${monitor.id}">Alterar</a>
                <button onclick="excluirMonitor(${monitor.id})">Excluir</button>
            </td>
        </tr>`;
    });
    tabela += "</table>";
    document.getElementById("divPrincipal").innerHTML = tabela;
}


// Função para buscar um monitor pelo ID e exibir na tela
function buscarMonitor() {
    const urlParams = new URLSearchParams(window.location.search);
    const id = parseInt(urlParams.get("id"));
    if (!id) {
        alert("ID não encontrado.");
        return;
    }

    fetch("http://localhost:8080/api/monitor/" + id, {
        method: "GET"
    })
        .then(res => res.json())
        .then(monitor => exibirMonitor(monitor))
        .catch(err => alert("Erro: " + err.message));
}


function exibirMonitor(monitor) {
    document.getElementById("id").value = monitor.id;
    document.getElementById("nome").value = monitor.nome;
    document.getElementById("tipo").value = monitor.tipo;
    document.getElementById("tamanho").value = monitor.tamanho;
    document.getElementById("preco").value = monitor.preco;
}


// Função para incluir um novo monitor
function incluirMonitor() {
    const monitor = {
        nome: document.getElementById("nome").value,
        tipo: document.getElementById("tipo").value,
        tamanho: parseFloat(document.getElementById("tamanho").value),
        preco: parseFloat(document.getElementById("preco").value)
    };

    fetch("http://localhost:8080/api/monitor", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(monitor)
    })
    .then(res => res.json())
    .then(res => {
        alert("Monitor incluido com sucesso");
        window.location.replace("Monitor.html");
    })
    .catch(err => alert("Erro: " + err.message));
}


function alterarMonitor() {

    const monitor = {
        id: parseInt(document.getElementById("id").value),
        nome: document.getElementById("nome").value,
        tipo: document.getElementById("tipo").value,
        tamanho: parseFloat(document.getElementById("tamanho").value),
        preco: parseFloat(document.getElementById("preco").value)
    };

    console.log(monitor);

    fetch("http://localhost:8080/api/monitor", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(monitor)
    })
    .then(res => res.json())
    .then(res => {
        alert("Monitor alterado com ID: " + res.id);
        window.location.replace("MonitorVisualizar.html?id=" + res.id);
    })
    .catch(err => alert("Erro: " + err.message));
}


// Função para excluir um monitor pelo ID
function excluirMonitor(id) {
    fetch("http://localhost:8080/api/monitor/" + id, {
        method: "DELETE"
    })
    .then(() => {
        alert("Monitor excluído com sucesso.");
        buscarMonitores();
    })
    .catch(err => alert("Erro: " + err.message));
}