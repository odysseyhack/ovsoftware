// Allows us to use ES6 in our migrations and tests.
require('babel-register')

module.exports = {
  networks: {
    dev: {
      host: '127.0.0.1',
      port: 8854,
      network_id: '*', // Match any network id
      gas: 8000000000,
      gasprice: 0,
    }
  }
}
