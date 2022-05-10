Vagrant.configure("2") do |config|
  config.vm.define "jenkins" do |jenkins|
    jenkins.vm.box = "ubuntu/xenial64"
    
    jenkins.vm.network "forwarded_port", guest: 8080, host: 8080

    jenkins.vm.provider "virtualbox" do |vb|
      vb.gui = false
      vb.cpus = 2
      vb.memory = "4096"
    end
    
    jenkins.vm.provision "shell" do |shell|
      shell.path = "jenkins.sh"
    end
  end

  config.vm.define "docker" do |docker|
    docker.vm.box = "ubuntu/xenial64"
    
    docker.vm.network "forwarded_port", guest: 4243, host: 4243

    docker.vm.provider "virtualbox" do |vb|
      vb.gui = false
      vb.cpus = 2
      vb.memory = "4096"
    end
    
    docker.vm.provision "shell" do |shell|
      shell.path = "docker.sh"
    end
  end
end