// http://latentflip.com/loupe/?code=JC5vbignYnV0dG9uJywgJ2NsaWNrJywgZnVuY3Rpb24gb25DbGljaygpIHsKICAgIHNldFRpbWVvdXQoZnVuY3Rpb24gdGltZXIoKSB7CiAgICAgICAgY29uc29sZS5sb2coJ1lvdSBjbGlja2VkIHRoZSBidXR0b24hJyk7ICAgIAogICAgfSwgMjAwMCk7Cn0pOwoKY29uc29sZS5sb2coIkhpISIpOwoKc2V0VGltZW91dChmdW5jdGlvbiB0aW1lb3V0KCkgewogICAgY29uc29sZS5sb2coIkNsaWNrIHRoZSBidXR0b24hIik7Cn0sIDUwMDApOwoKY29uc29sZS5sb2coIldlbGNvbWUgdG8gbG91cGUuIik7!!!PGJ1dHRvbj5DbGljayBtZSE8L2J1dHRvbj4%3D

// old callback hell
/*console.log('Request data...');

setTimeout(() => {
  console.log('Prepare data...');

  const backData = {
    server: 'aws',
    port: 2000,
    status: 'works',
  };

  setTimeout(() => {
    backData.modified = true;
    console.log('Data received', backData);
  }, 2000);
}, 2000);*/

const p = new Promise((resolve, reject) => {
  setTimeout(() => {
    console.log('Preparing data....');
    const backData = {
      server: 'aws',
      port: 2000,
      status: 'works',
    };
    resolve(backData);
  }, 2000)
});

/*p.then(backData => {
  const p2 = new Promise((resolve, reject) => {
    setTimeout(() => {
      backData.modified = true;
      resolve(backData);
    })
  });

  p2.then(clientData => {
    console.log('Data received', clientData);
  })
});*/

// или

p.then(backData => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      backData.modified = true;
      resolve(backData);
    })
  })
}).then(clientData => {
  console.log('Data received', clientData);
  clientData.fromPromise = true;
  return clientData;
}).then(data => { // this is sync call
  console.log('Data', data);
});

// общая схема
// promise ( res, rej ) {
// const remoteResource = openRemoteResource(url);
// у асинхронной операции есть колбэк, на этот колбэк резолвим промис
// remoteResource.callback = res();
// }
