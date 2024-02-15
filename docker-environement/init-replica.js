const replicaSetName = 'rs0';
const config = {
  _id: replicaSetName,
  members: [
    { _id: 0, host: "rs1:27017" },
    { _id: 1, host: "rs2:27017" },
    { _id: 2, host: "rs3:27017" }
  ]
};

// Try to get the replica set status
try {
  const status = rs.status();
  if (status.ok === 0 && status.code === 94) {  // NotYetInitialized
    print('Initializing the replica set...');
    rs.initiate(config);

    // Wait for the replica set to be fully initialized
    print('Waiting for the replica set to initialize...');
    while (rs.status().ok !== 1) {
      sleep(1000);
    }
    print('Replica set initialized.');
  } else {
    print('Replica set already initialized.');
  }
} catch (error) {
  print('Error initializing replica set:', error);
}
