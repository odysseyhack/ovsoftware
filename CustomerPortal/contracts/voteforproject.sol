pragma solidity ^0.5.0;

import './reti.sol';

contract VoteForProject {
    // describes a Project
    struct Project {
        string name;
        address wallet; 
        uint numVotes;
        uint numVotesNeeded;
    }

    // These state variables are used keep track of the number of Candidates/Voters 
    // and used to as a way to index them     
    uint numVoters;
    address owner;
    Project project;
    address _reti;
    
    constructor(address reti, string memory name, address wallet, uint numVotesNeeded) public {
        _reti = reti;
        project.name = name;
        project.wallet = wallet;
        project.numVotesNeeded = numVotesNeeded;
        owner = msg.sender;
    }
    function receiveApproval(address from, uint256 tokens, address token) public {
        require(token == _reti);
        Reti reti = Reti(token);
        if(project.numVotes < project.numVotesNeeded) {
            reti.transferFrom(from, address(this), tokens);
            project.numVotes += tokens; 
            numVoters++;
        }
        /* to be implemented: whe numvotes >= votesneeded transfer to wallet of project*/
    }

    function getNumOfVoters() public view returns(uint) {
        return numVoters;
    }
    
    function getProject() public view returns (string memory, address, uint, uint) {
        return (project.name, project.wallet, project.numVotes, project.numVotesNeeded);
    }
}
