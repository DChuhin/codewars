const delay = ms => {
  return new Promise(r => setTimeout(() => r(), ms));
};

const url = 'https://jsonplaceholder.typicode.com/todos';

/*
function fetchTodos() {
  return delay(2000)
    .then(() => fetch(url))
    .then(response => response.json())
}

fetchTodos()
  .then(data => console.log("data: ", data))
  .catch(console.error);*/

async function fetchAsyncTodos() {
  try {
    await delay(2000);
    const response = await fetch(url);
    const data = await response.json();
    console.log("data: ", data);
  } catch (e) {
    console.error(e);
  } finally {

  }
}

fetchAsyncTodos();