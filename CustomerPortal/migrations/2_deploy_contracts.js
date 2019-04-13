var Reti = artifacts.require('./reti.sol')

module.exports = function (deployer) {
  deployer.deploy(Reti,"1000000000000")
}
