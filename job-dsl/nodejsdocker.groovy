job('NodeJS_Docker_JobDSL') {
    scm {
        git('httpsgithub.comwardviaenedocker-demo.git') {  node -  is hudson.plugins.git.GitSCM
            node  gitConfigName('DSL User')
            node  gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H5    ')
    }
    wrappers {
        nodejs('nodejs')  this is the name of the NodeJS installation in 
                          Manage Jenkins - Configure Tools - NodeJS Installations - Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('abubakarcoolabubakar_cool')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}